package br.com.metrocamp.example.sergio.mvcsample.model.vo;

import java.util.Date;

/**
 * Created by Sergio on 4/22/18.
 */

public class Article {

    private String title;
    private Date date;
    private String source;
    private ArticleType type;

    /**
     * Gets the article title
     *
     *
     * @return Article title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the article title
     *
     * @param title Article title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the article date
     *
     * @return Article publishing day
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the article date
     *
     * @param date Article publishing day
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the article source
     *
     * @return
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the article source
     *
     * @param source Article source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the article type
     *
     * @return Article type
     */
    public ArticleType getType() {
        return type;
    }

    /**
     * Sets the article type
     *
     * @param type Article type
     */
    public void setType(ArticleType type) {
        this.type = type;
    }
}
