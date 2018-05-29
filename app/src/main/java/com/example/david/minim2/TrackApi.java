package com.example.david.minim2;

import com.example.david.minim2.Classes.Alumno;
import com.example.david.minim2.Classes.Expressio;

import java.util.Queue;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TrackApi {

    @GET("json/consultarAlumo/{id}")
    Call<Alumno> consultarAlumno(@Path("id") String nombre);

    @GET("json/procesarOperacion")
    Call<Integer> procesarOperacion();

    @POST("json/realizarOperacion/{user}")
    Call<Response> realizarOperacion (@Path("user") String user, @Body Queue<Expressio> llistaExpressions);




}
