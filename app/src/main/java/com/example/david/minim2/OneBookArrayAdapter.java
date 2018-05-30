package com.example.david.minim2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.minim2.Classes.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OneBookArrayAdapter extends ArrayAdapter<Book> {
    public OneBookArrayAdapter(@NonNull Context context, List<Book> resource) {
        super(context, 0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Book u = getItem(position);
        if (convertView == null) {
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_layout, parent, false);
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.one_lista_layout, parent, false);
        }

        //Picasso.with(super.getContext()).load(u.getImage_url()).into((ImageView) convertView.findViewById(R.id.foto_img));
        Picasso.with(super.getContext()).load("http://api.dsamola.tk/imagen.jpeg").into((ImageView) convertView.findViewById(R.id.foto_img));
        TextView et = (TextView)convertView.findViewById(R.id.username_txt);
        TextView et2 = (TextView)convertView.findViewById(R.id.title_txt);
        TextView et3 = (TextView)convertView.findViewById(R.id.descrip_txt);
        TextView et4 = (TextView)convertView.findViewById(R.id.pub_txt);
        TextView et5 = (TextView)convertView.findViewById(R.id.date_txt);
        TextView et6 = (TextView)convertView.findViewById(R.id.rate_txt);
        TextView et7 = (TextView)convertView.findViewById(R.id.id_txt);


        et.setText(u.getAutor()); //cojo los nombres de los autores
        et2.setText(u.getTitle());
        et3.setText(u.getDescription());
        et4.setText(u.getPublisher());
        et5.setText(u.getDate());
        int x = u.getRating();
        et6.setText(Integer.toString(x));
        et7.setText(u.get_id());

        return convertView;
    }
}
