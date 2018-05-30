package com.example.david.minim2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.david.minim2.Classes.Alumno;
import com.example.david.minim2.Classes.Instituto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Peticiones extends AppCompatActivity {

    public static final String BASE_URL = "http://api.dsamola.tk/";
    //public static final String BASE_URL = "http://147.83.7.206:8080/myapp/";
    //public static final String BASE_URL = "http://192.168.42.158:8080/myapp/";
    //public static final String BASE_URL ="http://localhost:8080/myapp/";
    private TrackApi trackServices;
    String tag = "Events";

    private Call<List<Instituto>> callInsti;

    ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peticiones);

        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackServices = retrofit.create(TrackApi.class);

    }

    public void listaInstis (View view){

        callInsti = trackServices.listarInstitutos();
        callInsti.enqueue(new Callback<List<Instituto>>() {

            @Override
            public void onResponse(Call<List<Instituto>> call, Response<List<Instituto>> response) {
                int statusCode = response.code();

                if (response.isSuccessful()) {

                    Toast.makeText (Peticiones.this,"Peticion correcta",Toast.LENGTH_LONG).show();
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode)+ "resultado:");

                    List<Instituto> instiList = response.body();
                    ListView lv = (ListView) findViewById(R.id.followers_list);
                    InstiArrayAdapter uaa = new InstiArrayAdapter(getApplicationContext(), instiList);
                    lv.setAdapter(uaa);

                    pb1.setVisibility(ProgressBar.INVISIBLE);//al final de la tasca

                    //Intent intentOj = new Intent(Peticiones.this, Peticiones.class);
                    //startActivity(intentOj);

                } else {
                    //al final de la tasca
                    pb1.setVisibility(ProgressBar.INVISIBLE);
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                    Toast.makeText (Peticiones.this,"Alumno/Insti erroneos",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Instituto>> call, Throwable t) {
                //al final de la tasca
                pb1.setVisibility(ProgressBar.INVISIBLE);
                // log error here since request failed
                Log.d("Request: ", "error loading API" + t.toString());
            }
        });


//        //inici de la tasca
//        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
//        pb1.setVisibility(ProgressBar.VISIBLE);
//
//
//        Intent intentOj = new Intent(Peticiones.this, Listar.class);
//        startActivity(intentOj);
//        //al final de la tasca
//        pb1.setVisibility(ProgressBar.INVISIBLE);


    }

    public void listaAlumnos (View view){

        //inici de la tasca
        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
        pb1.setVisibility(ProgressBar.VISIBLE);


        Intent intentOj = new Intent(Peticiones.this, Listar.class);
        startActivity(intentOj);
        //al final de la tasca
        pb1.setVisibility(ProgressBar.INVISIBLE);


    }

    public void listaOperaciones (View view){

        //inici de la tasca
        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
        pb1.setVisibility(ProgressBar.VISIBLE);


        Intent intentOj = new Intent(Peticiones.this, Listar.class);
        startActivity(intentOj);
        //al final de la tasca
        pb1.setVisibility(ProgressBar.INVISIBLE);


    }
}
