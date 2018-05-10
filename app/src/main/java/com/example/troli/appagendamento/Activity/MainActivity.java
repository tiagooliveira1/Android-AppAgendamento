package com.example.troli.appagendamento.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.troli.appagendamento.R;
import com.facebook.stetho.Stetho;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);
    }

    public void verCadastrarCompromisso(View v){
        Intent intent = new Intent(MainActivity.this,CadastroCompromissoActivity.class);
        startActivity(intent);
    }

    public void exibirListagem(View v){
        Intent intent = new Intent(MainActivity.this,ListagemActivity.class);
        startActivity(intent);
    }
}
