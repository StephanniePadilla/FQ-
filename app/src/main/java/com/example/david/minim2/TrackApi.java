package com.example.david.minim2;

import com.example.david.minim2.Classes.Book;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TrackApi {

    @GET("/books")
    Call<List<Book>> listaBook();

    @POST("/books")
    Call<Book> nuevoBook(@Body JSONObject bookJSON);

    @GET("/books/{id}")
    Call<Book> consultarBook(@Path("id") String _id);

    @PUT("/books/{id}")
    Call<Book> modificaBook(@Path("id") String _id, @Body JSONObject bookJSON);

    @DELETE("/books/{id}")
    Call<Book> borraBook(@Path("id") String _id);

}
