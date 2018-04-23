package br.com.metrocamp.example.sergio.mvcsample.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.metrocamp.example.sergio.mvcsample.R;
import br.com.metrocamp.example.sergio.mvcsample.model.vo.Article;

/**
 * Created by Sergio on 4/22/18.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{

    private List<Article> lista;
    private LayoutInflater inflater;

    // data is passed into the constructor
    public ArticleAdapter(Context context, List<Article> data) {
        this.inflater = LayoutInflater.from(context);
        this.lista = data;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView title;
        TextView date;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
        }
    }

    //Carrega uma célula do layout quando necessário
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.article_cell, parent, false);

        return new ArticleAdapter.ViewHolder(view);

    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = lista.get(position);
        holder.title.setText(article.getTitle());
        holder.date.setText(article.getDate().toString());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return lista.size();
    }
}
