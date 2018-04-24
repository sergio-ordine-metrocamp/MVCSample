package br.com.metrocamp.example.sergio.mvcsample.controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.metrocamp.example.sergio.mvcsample.R;
import br.com.metrocamp.example.sergio.mvcsample.model.vo.Article;

/**
 * Created by Sergio on 4/22/18.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{

    private List<Article> list;
    private LayoutInflater inflater;
    private Context context;


    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    // data is passed into the constructor
    public ArticleAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public List<Article> getList() {
        return list;
    }

    public void setList(List<Article> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView title;
        TextView date;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            icon = itemView.findViewById(R.id.icon);
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
        Article article = getList().get(position);
        holder.title.setText(article.getTitle());
        //Formatting rule! - Platform independent logic!
        holder.date.setText(formatter.format(article.getDate()));

        //Set image
        Drawable iconImage = null;
        switch (article.getType()) {
            case Science:
                iconImage = context.getDrawable(R.drawable.science);
                break;
            case Enterteinment:
                iconImage = context.getDrawable(R.drawable.enterteinment);
                break;
            default:
                    break;
        }

        holder.icon.setImageDrawable(iconImage);
        holder.icon.setColorFilter(context.getResources().getColor(R.color.colorPrimaryDark));

    }

    // total number of rows
    @Override
    public int getItemCount() {
        if (getList() != null) {
            return getList().size();
        } else {
            return 0;
        }

    }
}
