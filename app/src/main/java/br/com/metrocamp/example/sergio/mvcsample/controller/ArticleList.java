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
import java.util.Date;
import java.util.List;

import br.com.metrocamp.example.sergio.mvcsample.R;
import br.com.metrocamp.example.sergio.mvcsample.model.dao.SuperScienceMagazineDAO;
import br.com.metrocamp.example.sergio.mvcsample.model.vo.Article;

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
            }
        });

        FloatingActionButton enterteinmentButton = findViewById(R.id.enterteinmentButton);
        enterteinmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEnterteinmentEnabled = !isEnterteinmentEnabled;
                updateButton((FloatingActionButton)view, isEnterteinmentEnabled);
            }
        });

        RecyclerView lista = (RecyclerView)findViewById(R.id.articleList);
        lista.setLayoutManager(new LinearLayoutManager(this));

        try {
            Date startDate = formatter.parse("01/01/2018");
            Date endDate = new Date();
            SuperScienceMagazineDAO dao = new SuperScienceMagazineDAO();
            List<Article> articles = dao.getArticles(startDate,endDate);

            adapter = new ArticleAdapter(this, articles);
            lista.setAdapter(adapter);

        } catch (Exception ex) {

        }

        //adapter = new CompleteAdapter(this, CidadeServices.getClima());
        //lista.setAdapter(adapter);
        //adapter.setListener(this);




    }

    protected void updateButton(FloatingActionButton button, boolean state) {
        int color = getButtonColor(state);
        button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color)));
    }


    protected int getButtonColor(boolean state) {
        return state ? R.color.colorPrimaryDark: R.color.colorAccent;
    }

}
