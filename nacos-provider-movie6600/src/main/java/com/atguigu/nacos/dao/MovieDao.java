package com.atguigu.nacos.dao;

import com.atguigu.nacos.bean.Movie;
import org.springframework.stereotype.Repository;

/**
 * wbq
 * 2020/12/7
 */
@Repository
public class MovieDao {
    public Movie getNewMovie(){
        Movie movie = new Movie();
        movie.setId(1);
        movie.setMovieName("战狼");
        return movie;
    }
}
