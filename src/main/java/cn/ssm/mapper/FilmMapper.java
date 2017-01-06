package cn.ssm.mapper;

import java.util.List;

import cn.ssm.po.Film;

public interface FilmMapper extends BaseMapper<Film, Integer> {
	public Film getById(int film_id) throws Exception;
	public List<Film> getAll()throws Exception;
	public int selectCount(Film film) throws Exception;
	public int updatef(Film film) throws Exception;
	
	public int deleteByid(int film_id) throws Exception;
	public int changeFK(int a) throws Exception;
}
