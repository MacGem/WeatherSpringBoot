package pl.maciek.srpingBoot.model;

/**
 * Created by Admin on 27.07.2017.
 */
public class Article {


    private String category;

    public Article() {}

    public Article(String category){

        this.category= category;


    }

    @Override
    public String toString() {
        return category ;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
