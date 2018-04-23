package br.com.metrocamp.example.sergio.mvcsample.model.dao;

import android.util.Log;

import java.text.SimpleDateFormat;
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

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        //Create some simulated articles, to "simulate"
        //the access to an API
        //Suposing this API does not return the article type and source

        try {
            Article article = new Article();
            article.setDate(formatter.parse("24/12/2017"));
            article.setTitle("Fóssil de titanossauro é encontrado por acaso no interior de São Paulo.");
            list.add(article);

            article = new Article();
            article.setDate(formatter.parse("26/01/2018"));
            article.setTitle("Fóssil humano mais antigo fora da África é encontrado em Israel.");
            list.add(article);

            article = new Article();
            article.setDate(formatter.parse("21/04/2018"));
            article.setTitle("Fim de semana terá melhor momento para ver chuva de estrelas cadentes.");
            list.add(article);

            article = new Article();
            article.setDate(formatter.parse("20/04/2018"));
            article.setTitle("Chuva traz 800 milhões de vírus por metro quadrado; e não é o fim do mundo.");
            list.add(article);

            article = new Article();
            article.setDate(formatter.parse("14/03/2018"));
            article.setTitle("Morre aos 76 anos o físico Stephen Hawking.");
            list.add(article);

            article = new Article();
            article.setDate(formatter.parse("22/04/2018"));
            article.setTitle("Reconstituição mostra verdadeiro rosto de D. Pedro I com fratura no nariz.");
            list.add(article);

            article = new Article();
            article.setDate(formatter.parse("15/09/2017"));
            article.setTitle("Cassini: Nasa encerra missão de 20 anos com mergulho final em Saturno.");
            list.add(article);



        } catch (Exception ex) {
            Log.e("ARTICLE", "Erro recuperando dados");
        }

    }



    public List<Article> getArticles(Date from, Date to) {

        List<Article> filteredList = new ArrayList<>();

        for (Article article : list) {

            Date articleDate = article.getDate();

            if (articleDate.after(from) && articleDate.before(to)) {
                filteredList.add(article);
            }

        }

        return filteredList;

    }


}
