package com.example.david.minim2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.david.minim2.Classes.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DetalleLibro extends AppCompatActivity {

    public static final String BASE_URL = "http://api.dsamola.tk/";

    private TrackApi trackServices;
    String tag = "Events";

    private Call<List<Book>> callBook;

    ProgressBar pb1;
    String idLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_libro);

        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackServices = retrofit.create(TrackApi.class);
    }


    public void detalleBook (View view) {

        callBook = trackServices.listaBook();
        callBook.enqueue(new Callback<List<Book>>() {

            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                int statusCode = response.code();

                if (response.isSuccessful()) {

                    Toast.makeText(DetalleLibro.this, "Peticion correcta", Toast.LENGTH_LONG).show();
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode) + "resultado:");

                    List<Book> bookList = response.body();

                    final EditText et = (EditText)findViewById(R.id.username);
                    idLibro = et.getText().toString();

                    for(Book alum: bookList){
                        if (alum.get_id().equals(idLibro)) {
                            ListView lv = (ListView) findViewById(R.id.followers_list);
                            OneBookArrayAdapter uaa = new OneBookArrayAdapter(getApplicationContext(), bookList);
                            lv.setAdapter(uaa);

                            pb1.setVisibility(ProgressBar.INVISIBLE);//al final de la tasca
                        }
                    }

                    //Intent intentOj = new Intent(Peticiones.this, Peticiones.class);
                    //startActivity(intentOj);

                } else {
                    //al final de la tasca
                    pb1.setVisibility(ProgressBar.INVISIBLE);
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                    Toast.makeText(DetalleLibro.this, "Alumno/Insti erroneos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                //al final de la tasca
                pb1.setVisibility(ProgressBar.INVISIBLE);
                // log error here since request failed
                Log.d("Request: ", "error loading API" + t.toString());
            }
        });
    }

   /* public void detalleBook (View view) {

        final EditText et = (EditText)findViewById(R.id.username);
        idLibro = et.getText().toString();


        //callBook = trackServices.consultarBook(""+idLibro);
        callBook = trackServices.listaBook();
        callBook.enqueue(new Callback<Book>() {

            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                int statusCode = response.code();

                if (response.isSuccessful()) {

                    Toast.makeText(DetalleLibro.this, "Peticion correcta", Toast.LENGTH_LONG).show();
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode) + "resultado:");

                    Book book = response.body();

                    ListView lv = (ListView) findViewById(R.id.followers_list);
                    OneBookArrayAdapter uaa = new OneBookArrayAdapter(getApplicationContext(), book);
                    lv.setAdapter(uaa);

                    pb1.setVisibility(ProgressBar.INVISIBLE);//al final de la tasca

                    //Intent intentOj = new Intent(Peticiones.this, Peticiones.class);
                    //startActivity(intentOj);

                } else {
                    //al final de la tasca
                    pb1.setVisibility(ProgressBar.INVISIBLE);
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                    Toast.makeText(DetalleLibro.this, "Alumno/Insti erroneos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                //al final de la tasca
                pb1.setVisibility(ProgressBar.INVISIBLE);
                // log error here since request failed
                Log.d("Request: ", "error loading API" + t.toString());
            }
        });
    }*/
}
