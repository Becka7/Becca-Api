package models;

import java.util.Objects;

public class News {
    private int id;
    private String text;

    public News(String text) {
        this.text = text;
    }

    public int getId() {

        return id;
    }

    public String getPost() {

        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPost(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, id);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News that = (News) o;
        return id == that.id && Objects.equals(text, that.text);
    }
}


