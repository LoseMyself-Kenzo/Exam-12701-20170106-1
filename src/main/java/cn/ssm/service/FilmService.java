package cn.ssm.service;

import java.util.List;

import cn.ssm.po.Film;
import cn.ssm.po.FilmQueryVo;

public interface FilmService {

	public FilmQueryVo getById(int film_id) throws Exception;
	
	boolean addFilm(Film film)throws Exception;
	
	public List<Film> getAll()throws Exception;
	
	public boolean updatef(Film film) throws Exception;
	
	public boolean deleteByid(int film_id) throws Exception;
	
	public boolean changeFK(int a) throws Exception;
}
