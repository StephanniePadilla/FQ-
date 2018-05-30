package com.example.david.minim2.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Book {
    @SerializedName("autor")
    @Expose
    private String autor;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("image_url")
    @Expose
    private String image_url;

    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("publisher")
    @Expose
    private String publisher;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("rating")
    @Expose
    private int rating;

    @SerializedName("coments")
    @Expose
    private ArrayList<Coments> listaComents = new ArrayList<Coments>();

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "autor='" + autor + '\'' +
                ", title='" + title + '\'' +
                ", description=" + description+
                ", publisher=" + publisher +
                ", date=" + date +
                ", image_url=" + image_url +
                ", rating=" + rating +
                ", listaComents=" + listaComents +
                ", _id=" + _id +
                '}';
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
