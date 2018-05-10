package com.example.troli.appagendamento.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.troli.appagendamento.DAO.Compromisso;
import com.example.troli.appagendamento.R;

import java.util.List;

/**
 * Created by troli on 09/05/2018.
 */

public class CompromissoAdapter extends ArrayAdapter<Compromisso> {

    private int resource;
    private List<Compromisso> compromissos;

    public CompromissoAdapter(Context context, int resource, List<Compromisso> objects) {
        super(context, resource, objects);
        this.resource = resource;
        compromissos = objects;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(resource,null,false);
        }

        Compromisso compromisso = compromissos.get(position);

        TextView textID = (TextView) mView.findViewById(R.id.textItemCompromissoID);
        TextView textTitulo = (TextView) mView.findViewById(R.id.textItemCompromissoTitulo);
        TextView textData = (TextView) mView.findViewById(R.id.textItemCompromissoData);
        TextView textDescricao = (TextView) mView.findViewById(R.id.textItemCompromissoDescricao);
        TextView textPrioridade = (TextView) mView.findViewById(R.id.textItemCompromissoPrioridade);

        if(textID != null){
            textID.setText(String.valueOf(compromisso.get_id()));
        }
        if(textTitulo != null){
            textTitulo.setText(compromisso.getTitulo());
        }
        if(textData != null){
            //long teste = compromisso.getData();
            //textData.setText(teste.toString());
        }
        if(textDescricao != null){
            textDescricao.setText(compromisso.getDescricao());
        }
        if(textPrioridade != null){
            textPrioridade.setText(compromisso.getPrioridade());
            //Integer.parseInt(compromisso.getPrioridade().toString()).toString();
        }
        return mView;
    }
}
