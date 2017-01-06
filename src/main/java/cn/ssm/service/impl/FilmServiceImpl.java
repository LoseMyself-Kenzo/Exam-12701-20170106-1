package cn.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ssm.mapper.FilmMapper;
import cn.ssm.po.Film;
import cn.ssm.po.FilmQueryVo;
import cn.ssm.service.FilmService;

public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmMapper filmMapper;
	
	@Override
	public FilmQueryVo getById(int film_id) throws Exception {
		FilmQueryVo fqv = new FilmQueryVo();
		fqv.setFilm(filmMapper.getById(film_id));
		return fqv;
	}

	@Override
	public boolean addFilm(Film film) throws Exception {
		boolean flag = false;
		if (filmMapper.insert(film) > 0) {
			return flag = true;
		} else
			return flag;
	}

	@Override
	public List<Film> getAll() throws Exception {
		List<Film> lfqv = filmMapper.getAll();
		return lfqv;
	}

	@Override
	public boolean updatef(Film film) throws Exception {
		boolean flag = false;
		if(filmMapper.updatef(film) >0)
		flag = true;
		return flag;
	}

	@Override
	public boolean deleteByid(int film_id) throws Exception {
		
		boolean flag = false;
		filmMapper.changeFK(0);
		
		if(filmMapper.deleteByid(film_id)>0)
			flag = true;
		
		filmMapper.changeFK(1);
		return flag;
	}

	@Override
	public boolean changeFK(int a) throws Exception {
		boolean flag = false;
		if(filmMapper.changeFK(a)>0);
			flag = true;
		return flag;
	}
}
