    package br.com.metrocamp.example.sergio.mvcsample.model.dao;

    import android.util.Log;

    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    import br.com.metrocamp.example.sergio.mvcsample.model.vo.Article;

    /**
     * Created by Sergio on 4/23/18.
     */

    public class WorldOfLineNewsDAO {

        private List<WOLArticle> list;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        private class WOLArticle extends Article {
            private String category;

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }
        }


        public WorldOfLineNewsDAO() {

            list = new ArrayList<WOLArticle>();

            try {
                WOLArticle article = new WOLArticle();
                article.setDate(formatter.parse("19/04/2018"));
                article.setTitle("\"Han Solo: Uma História Star Wars é uma história de amor entre Han e Chewie\", diz roteirista");
                article.setCategory("cinema");
                list.add(article);

                article = new WOLArticle();
                article.setDate(formatter.parse("23/04/2018"));
                article.setTitle("Sequência de Pantera Negra? Marvel diz que decisão depende de Ryan Coogler");
                article.setCategory("cinema");
                list.add(article);

                article = new WOLArticle();
                article.setDate(formatter.parse("23/04/2018"));
                article.setTitle("Wanessa Camargo se machucou nos ensaios para o clipe de \"Mulher Gato\"");
                article.setCategory("musica");
                list.add(article);


                article = new WOLArticle();
                article.setDate(formatter.parse("23/04/2018"));
                article.setTitle("Maurício de Sousa e Dedé Santana anunciam ‘Circo Turma da Mônica’");
                article.setCategory("musica");
                list.add(article);

                article = new WOLArticle();
                article.setDate(formatter.parse("12/04/2018"));
                article.setTitle("Pokémon deve ganhar atração em parque da Universal Studios, na Flórida");
                article.setCategory("cultura");
                list.add(article);


                article = new WOLArticle();
                article.setDate(formatter.parse("29/11/2017"));
                article.setTitle("11 destaques e referências do trailer de Vingadores: Guerra Infinita");
                article.setCategory("cultura");
                list.add(article);

            } catch (Exception ex) {
                Log.e("ARTICLE", "Erro recuperando dados");
            }

        }


        public List<Article> getArticles(Date from, Date to, List<String> categories) {

            List<Article> filteredList = new ArrayList<>();

            for (WOLArticle article : list) {

                Date articleDate = article.getDate();

                if (articleDate.after(from)
                        && articleDate.before(to)
                        && categories.contains(article.getCategory())) {
                    filteredList.add(article);
                }

            }

            return filteredList;

        }

    }
