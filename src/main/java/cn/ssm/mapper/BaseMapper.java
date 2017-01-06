package cn.ssm.mapper;

import cn.ssm.po.Film;


public interface BaseMapper<T, P> {
    T getById(P id);

    int update(T dto);

    int delete(T dto);

    int insert(Film film);
}