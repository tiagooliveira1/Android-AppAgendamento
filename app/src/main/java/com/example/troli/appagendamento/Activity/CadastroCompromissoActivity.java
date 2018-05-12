package com.example.troli.appagendamento.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.troli.appagendamento.DAO.AppDatabase;
import com.example.troli.appagendamento.DAO.Compromisso;
import com.example.troli.appagendamento.DAO.CompromissoDAO;
import com.example.troli.appagendamento.R;

public class CadastroCompromissoActivity extends Activity {

    private EditText editTituloCompromisso;
    private EditText editDescricaoCompromisso;
    private EditText editPrioridadeCompromisso;
    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_compromisso);

        editTituloCompromisso = (EditText) findViewById(R.id.txtTituloCompromisso);
        editDescricaoCompromisso = (EditText) findViewById(R.id.txtDescricaoCompromisso);
        editPrioridadeCompromisso = (EditText) findViewById(R.id.txtPrioridadeCompromisso);
        calendarView = (CalendarView) findViewById(R.id.calendarioDatas);

    }

    public void salvarCompromisso(View v) {
        final AppDatabase app = AppDatabase.getDatabase(this);
        CompromissoDAO compromissoDAO= app.compromissoDAO();

        Compromisso compromisso = new Compromisso();

        compromisso.setDescricao(editDescricaoCompromisso.getText().toString());
        compromisso.setTitulo(editTituloCompromisso.getText().toString());
        compromisso.setPrioridade(Integer.parseInt(editPrioridadeCompromisso.getText().toString()));

        compromisso.setData(calendarView.getDate());

        long resultado = compromissoDAO.inserir(compromisso);
        if(resultado > 0) {
            exibirMensagem("Cadastrado com sucesso");
            Intent intent = new Intent(CadastroCompromissoActivity.this,MainActivity.class);
            startActivity(intent);
        } else {
            exibirMensagem("Problemas ao cadastrar");
        }
    }

    private void excluirCompromisso(View v) {
        final AppDatabase app = AppDatabase.getDatabase(this);
        CompromissoDAO compromissoDAO= app.compromissoDAO();

        Compromisso compromisso = new Compromisso();

        compromisso.setDescricao(editDescricaoCompromisso.getText().toString());
        compromisso.setTitulo(editTituloCompromisso.getText().toString());
        compromisso.setPrioridade(Integer.parseInt(editPrioridadeCompromisso.getText().toString()));

        compromisso.setData(calendarView.getDate());

        long resultado = compromissoDAO.inserir(compromisso);
        if(resultado > 0) {
            exibirMensagem("Compromisso cadastrado com sucesso");
            Intent intent = new Intent(CadastroCompromissoActivity.this,MainActivity.class);
            startActivity(intent);
        } else {
            exibirMensagem("Problemas ao cadastrar novo compromisso");
        }
    }
    private void exibirMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }


}
