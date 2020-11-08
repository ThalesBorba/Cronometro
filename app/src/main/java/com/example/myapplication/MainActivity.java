package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText nameinput;
    TextView valor;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor = findViewById(R.id.valor);
        final Button iniciar = findViewById(R.id.iniciar);
        nameinput = (EditText) findViewById(R.id.input);
        iniciar.setVisibility(View.VISIBLE);
        nameinput.setVisibility(View.VISIBLE);



        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameinput.getText().toString().matches("")) {
                    showToast("Digite um número");
                    return;
                }
                contador = Integer.parseInt(nameinput.getText().toString());
                if(contador > 59) {
                    showToast("Máximo permitido é de 59 segundos!");
                    return;
                } else {
                    iniciar.setVisibility(View.GONE);
                    nameinput.setVisibility(View.GONE);
                    new CountDownTimer(contador * 1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            valor.setText(String.format("%02d:%02d", 00, millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            valor.setText("Fim");
                            iniciar.setVisibility(View.VISIBLE);
                            nameinput.setVisibility(View.VISIBLE);
                        }
                    }.start();
                }
                }

        } );
        valor.setText("00:00");

    }

    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}