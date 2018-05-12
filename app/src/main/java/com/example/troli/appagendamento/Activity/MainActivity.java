package com.example.troli.appagendamento.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.troli.appagendamento.R;
import com.facebook.stetho.Stetho;

public class MainActivity extends Activity {

    private CalendarView calendarViewBusca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        calendarViewBusca = (CalendarView) findViewById(R.id.calendarioDataBuscar);

        calendarViewBusca.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                realizarBusca(view);
                //Toast.makeText(getApplicationContext(), "" + dayOfMonth, 0).show();// TODO Auto-generated method stub

            }
        });
    }

    public void verCadastrarCompromisso(View v){
        Intent intent = new Intent(MainActivity.this,CadastroCompromissoActivity.class);
        startActivity(intent);
    }

    public void exibirListagem(View v){
        Intent intent = new Intent(MainActivity.this,ListagemActivity.class);
        startActivity(intent);
    }

    public void realizarBusca(View v){
        Intent intent = new Intent(MainActivity.this,ListagemActivity.class);
        intent.putExtra("DATA_BUSCA", calendarViewBusca.getDate());
        startActivity(intent);
    }
}
