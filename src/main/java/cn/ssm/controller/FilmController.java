package cn.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ssm.po.Film;
import cn.ssm.po.FilmQueryVo;
import cn.ssm.service.FilmService;
import cn.ssm.service.LanguageService;
import cn.ssm.service.LoginService;

@Controller
public class FilmController {

	@Autowired
	private FilmService filmService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private LanguageService languageService;

	@RequestMapping(value = "toAdd")
	// 跳转到展示页面
	public void toAdd(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.getRequestDispatcher("/WEB-INF/add.html").forward(req, res);
	}

	@RequestMapping(value = "toShow")
	public void toShow(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.getRequestDispatcher("/WEB-INF/show.html").forward(req, res);
	}

	@RequestMapping(value = "add")
	public void add(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
		Boolean flag = false;
		if (title.equals("") || title.equals(null)) {
			req.getRequestDispatcher("/WEB-INF/add/addnull.html").forward(req, res);
		} else if (description.equals("") || description.equals(null)) {
			req.getRequestDispatcher("/WEB-INF/add/addnull.html").forward(req, res);
		} else if (language.equals("") || language.equals(null)) {
			req.getRequestDispatcher("/WEB-INF/add/addnull.html").forward(req, res);
		} else {
			Film film = new Film();
			film.setDescription(description);
			film.setLanguage_id(languageService.getLanguageId(language));
			film.setTitle(title);
			flag = filmService.addFilm(film);
			if (flag == false) {
				req.getRequestDispatcher("/WEB-INF/add/addfail.html").forward(req, res);
			} else {
				req.getRequestDispatcher("/WEB-INF/add/addtrue.html").forward(req, res);
			}

		}
	}

	@RequestMapping(value = "toLogin")
	public void toLogin(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String userName = req.getParameter("first_name");
		String str = null;
		str = loginService.findCustomerByName(userName);

		if (str != null) {
			req.getSession().setAttribute("LOGIN_USER", userName);
			req.getRequestDispatcher("/WEB-INF/show.html").forward(req, res);
		} else {
			req.getRequestDispatcher("WEB-INF/faillogin.html").forward(req, res);
		}

	}

	@RequestMapping(value = "/toShowAll")
	public @ResponseBody List<FilmQueryVo> showAll(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Film> lf = filmService.getAll();	
		List<FilmQueryVo> lfqv = new ArrayList<FilmQueryVo>();
		for (Film attribute : lf) {
			FilmQueryVo fqv = new FilmQueryVo();
			fqv.setFilm(attribute);
			fqv.setLanguage(languageService.getLanguageName(fqv.getFilm().getLanguage_id()));
			lfqv.add(fqv);
		}
		return lfqv;
	}

	@RequestMapping(value = "/toShowOne")
	public @ResponseBody FilmQueryVo showOne(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int film_id = Integer.parseInt(req.getParameter("film_id"));
		FilmQueryVo fqv = filmService.getById(film_id);
		fqv.setLanguage(languageService.getLanguageName(fqv.getFilm().getLanguage_id()));
		return fqv;

	}
	
	@RequestMapping(value = "/toDelete")
	public void toDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int film_id = Integer.parseInt(req.getParameter("film_id"));
		boolean flag = false;
		flag = filmService.deleteByid(film_id);
		if(flag == true){
			req.getRequestDispatcher("WEB-INF/show/showt.html").forward(req, res);
		}else{
			req.getRequestDispatcher("WEB-INF/showf.html").forward(req, res);
		}
		
	}
	
	@RequestMapping(value = "/toUpdate")
	public void toUpdate(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
		int film_id = Integer.parseInt(req.getParameter("film_id"));
		Film f = new Film();
		f.setFilm_id(film_id);
		f.setLanguage_id(languageService.getLanguageId(language));
		f.setDescription(description);
		f.setTitle(title);
		boolean flag = false;
		flag = filmService.updatef(f);
		if(flag == true){
			req.getRequestDispatcher("WEB-INF/edit/editt.html?film_id="+film_id).forward(req, res);
		}else{
			req.getRequestDispatcher("WEB-INF/edit/editf.html?film_id="+film_id).forward(req, res);
		}

	}

}
