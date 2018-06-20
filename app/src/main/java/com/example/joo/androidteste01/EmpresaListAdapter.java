package com.example.joo.androidteste01;

import android.content.Context;
import android.support.annotation.NonNull;
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
    private int mResource;
    //private int lasposition = -1;

    /*ESSA CLASSE FOI CRIADA SOMENTE POR QUE O
    * SITE DO ANDROID DIZIA QUE ERA UMA BOA PRATICA
    * E EVITA PROBLEMAS COM NUMERO ELEVADO DE INFORMAÇÕES
    * */

    static class ViewHolder{
        TextView tvNome;
        TextView tvHorario;
        CheckBox chFavorito;
    }


    public EmpresaListAdapter(Context context, int resource, ArrayList<Empresas> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*Get PEGA as informações das empresas*/
        String nome = getItem(position).getNome();
        String horario = getItem(position).getHorario();
        boolean favorito = getItem(position).isFavorito();


        /*Cria o objeto Empresas com as informações*/
        Empresas empresa = new Empresas(nome,horario,favorito);
        /*
        //MOSTRAR ANIMAÇÃO
        final View result;
        */
        ViewHolder holder;

        //LOGICA PARA QUE SÓ CARREGUE O QUE ESTIVER SENDO MOSTRADO
        //PARA QUE FIQUE MAIS LEVE E RAPIDO
        if (convertView == null){

            //INFORMAÇÕES INFLANDO AS ESTRUTURAS DE LAYOUT
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            //ESTRUTURAS QUE REPRESENTANTES DO LAYOUT list_layout

            holder = new ViewHolder();
            holder.tvNome = (TextView) convertView.findViewById(R.id.titulo);
            holder.tvHorario = (TextView) convertView.findViewById(R.id.textView2);
            holder.chFavorito= (CheckBox) convertView.findViewById(R.id.checkBox);

            //result = convertView;

            convertView.setTag(holder);
        }else{
            /*QUANDO ESSE ITEM APARECER UMA VEZ FICARA GUARDADO EM UMA MEMORIA TEPORARIA
            * PARA QUE NAO SEJA NECESSARIO CARREGAR TODA VEZ
            * DEIXANDO MAIS LEVE E RAPIDO*/
            holder = (ViewHolder) convertView.getTag();
            //result = convertView;
        }
        /*
        //declarar a animação


        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lasposition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lasposition = position;
        */
        //VALORES RESPECTIVOS
        holder.tvNome.setText(nome);
        holder.tvHorario.setText(horario);
        holder.chFavorito.setChecked(favorito);


        return convertView;

    }
}
