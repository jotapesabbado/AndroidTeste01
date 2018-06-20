package com.example.joo.androidteste01;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by João on 19/06/2018.
 */

public class EmpresaListAdapter extends ArrayAdapter<Empresas> {

    private static final String TAG = "EmpresaListAdapter";
    private Context mContext;
    int mResource;


    public EmpresaListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Empresas> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /*Get PEGA as informações das empresas*/
        String nome = getItem(position).getNome();
        String horario = getItem(position).getHorario();
        boolean favorito = getItem(position).isFavorito();


        /*Cria o objeto Empresas com as informações*/
        Empresas empresa = new Empresas(nome,horario,favorito);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvNome = (TextView) convertView.findViewById(R.id.titulo);
        TextView tvHorario = (TextView) convertView.findViewById(R.id.textView2);
        CheckBox chFavorito= (CheckBox) convertView.findViewById(R.id.checkBox);

        return convertView;

    }
}
