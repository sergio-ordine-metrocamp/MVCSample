package br.com.metrocamp.example.sergio.mvcsample.controller;

import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import br.com.metrocamp.example.sergio.mvcsample.R;
import br.com.metrocamp.example.sergio.mvcsample.model.dao.SuperScienceMagazineDAO;
import br.com.metrocamp.example.sergio.mvcsample.model.dao.WorldOfLineNewsDAO;
import br.com.metrocamp.example.sergio.mvcsample.model.vo.Article;
import br.com.metrocamp.example.sergio.mvcsample.model.vo.ArticleType;

public class ArticleList extends AppCompatActivity {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    boolean isScienceEnabled = false;
    boolean isEnterteinmentEnabled = false;

    ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        //Buttons
        FloatingActionButton scienceButton = findViewById(R.id.scienceButton);
        scienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isScienceEnabled = !isScienceEnabled;
                updateButton((FloatingActionButton)view, isScienceEnabled);
                updateArticles();
            }
        });

        FloatingActionButton enterteinmentButton = findViewById(R.id.enterteinmentButton);
        enterteinmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEnterteinmentEnabled = !isEnterteinmentEnabled;
                updateButton((FloatingActionButton)view, isEnterteinmentEnabled);
                updateArticles();
            }
        });

        RecyclerView lista = (RecyclerView)findViewById(R.id.articleList);
        lista.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ArticleAdapter(this);
        lista.setAdapter(adapter);

    }

    protected void updateButton(FloatingActionButton button, boolean state) {
        int color = getButtonColor(state);
        button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color)));
    }


    protected int getButtonColor(boolean state) {
        return state ? R.color.colorPrimaryDark: R.color.colorAccent;
    }


    protected void updateArticles() {

        List<Article> articles = new ArrayList<>();


            try {
                //News from this year...
                Date startDate = formatter.parse("01/01/2018");
                Date endDate = new Date();

                //Business logic!
                if (isScienceEnabled) {
                    //Get the article list
                    SuperScienceMagazineDAO dao = new SuperScienceMagazineDAO();

                    List<Article> partialList = dao.getArticles(startDate, endDate);

                    for (Article article:partialList) {
                        article.setType(ArticleType.Science);
                    }


                    articles.addAll(partialList);
                }
                if (isEnterteinmentEnabled) {

                    WorldOfLineNewsDAO dao = new WorldOfLineNewsDAO();

                    List<String> categories = new ArrayList<String>(Arrays.asList("cinema",
                            "entretenimento",
                            "cultura"));

                    List<Article> partialList = dao.getArticles(startDate,endDate,categories);

                    for (Article article:partialList) {
                        article.setType(ArticleType.Enterteinment);
                    }

                    articles.addAll(partialList);
                }
            } catch (Exception ex) {
                //Notify errors to user
            }

        //Presentation logic (Platform-independent!) - Sort articles by date
        Collections.sort(articles, new Comparator<Article>() {
            public int compare(Article o1, Article o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        adapter.setList(articles);
    }


}
