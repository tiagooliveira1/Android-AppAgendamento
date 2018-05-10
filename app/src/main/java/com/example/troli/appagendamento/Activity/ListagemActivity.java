package com.example.troli.appagendamento.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.troli.appagendamento.Adapter.CompromissoAdapter;
import com.example.troli.appagendamento.DAO.AppDatabase;
import com.example.troli.appagendamento.DAO.Compromisso;
import com.example.troli.appagendamento.DAO.CompromissoDAO;
import com.example.troli.appagendamento.R;

import java.util.List;

public class ListagemActivity extends Activity {

    private ListView listaSistemas;
    private CompromissoAdapter myAdapter;
    CompromissoDAO compromissoDAO;
    AppDatabase app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        app = AppDatabase.getDatabase(this);
        compromissoDAO = app.compromissoDAO();
        carregarElementos();
    }

    public void carregarElementos(){

        listaSistemas = (ListView) findViewById(R.id.listCompromissos);

        List<Compromisso> sistemas = compromissoDAO.findAll();

        myAdapter = new CompromissoAdapter(this,R.layout.item_compromisso_listagem,sistemas);
        listaSistemas.setAdapter(myAdapter);
        listaSistemas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Compromisso compromisso = (Compromisso) parent.getItemAtPosition(position);
                //Intent atualizarIntent = new Intent(ListagemActivity.this,AtualizarSistemaActivity.class);
                //atualizarIntent.putExtra("ID_LIVRO",sistema.getID());
                //startActivity(atualizarIntent);
            }
        });
    }
}
