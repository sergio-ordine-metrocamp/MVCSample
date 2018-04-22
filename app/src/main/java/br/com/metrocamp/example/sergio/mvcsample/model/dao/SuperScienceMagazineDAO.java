package br.com.metrocamp.example.sergio.mvcsample.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.metrocamp.example.sergio.mvcsample.model.vo.Article;

/**
 * Created by Sergio on 4/22/18.
 */

public class SuperScienceMagazineDAO {

    private List<Article> list;

    public SuperScienceMagazineDAO() {

        list = new ArrayList<Article>();

        //Create some simulated articles, to "simulate"
        //the access to an API

        Article article = new Article();
        article.setTitle("");



    }



    public List<Article> getArticles(Date from, Date to) {




    }


}
