package com.example.david.minim2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.minim2.Classes.Instituto;
//import com.squareup.picasso.Picasso;

import java.util.List;

public class InstiArrayAdapter extends ArrayAdapter<Instituto> {
    public InstiArrayAdapter(@NonNull Context context, List<Instituto> resource) {
        super(context, 0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Instituto u = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_layout, parent, false);
        }
        //Picasso.with(super.getContext()).load(u.getAvatar_url()).into((ImageView) convertView.findViewById(R.id.avatar_image));
        //Picasso.with(super.getContext()).load(PONER_AQUI_URL).into((ImageView) convertView.findViewById(R.id.avatar_image));
        TextView et = (TextView)convertView.findViewById(R.id.username_txt);


        et.setText(u.getNombreInstituto()); //cojo los nombres de los institutos
        int x = u.getNumOperacionesTotales();

        return convertView;
    }
}
