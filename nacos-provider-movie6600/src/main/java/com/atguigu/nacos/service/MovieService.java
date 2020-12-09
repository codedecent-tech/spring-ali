package com.atguigu.nacos.service;

import com.atguigu.nacos.bean.Movie;
import com.atguigu.nacos.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * wbq
 * 2020/12/7
 */
@Service
public class MovieService {
    @Autowired
    MovieDao movieDao;
    public Movie getNewMovie(){
        return movieDao.getNewMovie();
    }
}
