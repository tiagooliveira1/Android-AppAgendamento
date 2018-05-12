package com.example.troli.appagendamento.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.troli.appagendamento.DAO.AppDatabase;
import com.example.troli.appagendamento.DAO.Compromisso;
import com.example.troli.appagendamento.DAO.CompromissoDAO;
import com.example.troli.appagendamento.R;

import java.util.Calendar;

public class AtualizarCompromissoActivity extends Activity {

    private int ID_COMPROMISSO;
    private Compromisso compromisso;
    private CompromissoDAO compromissoDAO;
    private AppDatabase app;

    private EditText txtAtualizaTitulo;
    private EditText txtAtualizarDescricao;
    private EditText txtAtualizarPrioridade;
    private CalendarView calendarioDatasAtualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_compromisso);

        //txtAtualizarID = (EditText) findViewById(R.id.txtAtualizarID);
        txtAtualizaTitulo = (EditText) findViewById(R.id.txtAtualizarTitulo);
        txtAtualizarDescricao = (EditText) findViewById(R.id.txtAtualizarDescricao);
        txtAtualizarPrioridade = (EditText) findViewById(R.id.txtAtualizarPrioridade);
        calendarioDatasAtualizar = (CalendarView) findViewById(R.id.calendarioDatasAtualizar);



        Intent intent = getIntent();
        if(intent.hasExtra("ID_COMPROMISSO")){
            ID_COMPROMISSO = intent.getIntExtra("ID_COMPROMISSO",0);
        }

        app = AppDatabase.getDatabase(this);
        compromissoDAO = app.compromissoDAO();

        compromisso = compromissoDAO.findByID(ID_COMPROMISSO);


        txtAtualizaTitulo.setText(compromisso.getTitulo());
        txtAtualizarDescricao.setText(compromisso.getDescricao());
        txtAtualizarPrioridade.setText(Integer.toString(compromisso.getPrioridade()));
        calendarioDatasAtualizar.setDate(compromisso.getData());

    }

    public void atualizarCompromisso(View v) {
        final AppDatabase app = AppDatabase.getDatabase(this);
        CompromissoDAO compromissoDAO= app.compromissoDAO();

        Compromisso compromisso = new Compromisso();

        compromisso.set_id(ID_COMPROMISSO);
        compromisso.setDescricao(txtAtualizarDescricao.getText().toString());
        compromisso.setTitulo(txtAtualizaTitulo.getText().toString());
        compromisso.setPrioridade(Integer.parseInt(txtAtualizarPrioridade.getText().toString()));

        compromisso.setData(calendarioDatasAtualizar.getDate());

        long resultado = compromissoDAO.editar(compromisso);
        if(resultado > 0) {
            exibirMensagem("Compromisso atualizado com sucesso");
            Intent intent = new Intent(AtualizarCompromissoActivity.this,ListagemActivity.class);
            startActivity(intent);
        } else {
            exibirMensagem("Problemas ao atualizar compromisso");
        }
    }

    public void excluirCompromisso(View v) {
        final AppDatabase app = AppDatabase.getDatabase(this);
        CompromissoDAO compromissoDAO= app.compromissoDAO();

        Compromisso compromisso = new Compromisso();

        compromisso.set_id(ID_COMPROMISSO);
        /*compromisso.setDescricao(txtAtualizarDescricao.getText().toString());
        compromisso.setTitulo(txtAtualizaTitulo.getText().toString());
        compromisso.setPrioridade(Integer.parseInt(txtAtualizarPrioridade.getText().toString()));

        compromisso.setData(calendarioDatasAtualizar.getDate()); */

        long resultado = compromissoDAO.excluir(compromisso);
        if(resultado > 0) {
            exibirMensagem("Compromisso excluído com sucesso");
            Intent intent = new Intent(AtualizarCompromissoActivity.this,ListagemActivity.class);
            startActivity(intent);
        } else {
            exibirMensagem("Problemas ao excluir compromisso");
        }
    }

    private void exibirMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
