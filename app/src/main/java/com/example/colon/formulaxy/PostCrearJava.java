package com.example.colon.formulaxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PostCrearJava extends AppCompatActivity {

    EditText Titulo;
    EditText Content;
    Button cpm;
    Button cpq;
    Button cpf;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_post_crear);
        cpm = findViewById(R.id.cpm);
        cpq = findViewById(R.id.cpq);
        cpf = findViewById(R.id.cpf);

        Titulo = findViewById(R.id.Titulo);
        Content = findViewById(R.id.Contenido);

        cpm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = Titulo.getText().toString();
                String c = Content.getText().toString();
                if(MainActivity.token == ""){
                    Toast post_error = Toast.makeText(getApplicationContext(), "No se ah iniciado sesion", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else if(MainActivity.token == ""){
                    Toast post_error = Toast.makeText(getApplicationContext(), "No se ah especificado el grupo", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else{
                    FxyApi api = new FxyApi();
                    String msg = api.createPost(t, c, MainActivity.Group, "Matematicas");
                    if(msg != "Ok"){
                        Toast post_error = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                        post_error.show();
                    }
                }
            }
        });
        cpq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = Titulo.getText().toString();
                String c = Content.getText().toString();
                if(MainActivity.token == ""){
                    Toast post_error = Toast.makeText(getApplicationContext(), "No se ah iniciado sesion", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else if(MainActivity.token == ""){
                    Toast post_error = Toast.makeText(getApplicationContext(), "No se ah especificado el grupo", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else{
                    FxyApi api = new FxyApi();
                    String msg = api.createPost(t, c, MainActivity.Group, "Quimica");
                    if(msg != "Ok"){
                        Toast post_error = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                        post_error.show();
                    }
                }
            }
        });
        cpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = Titulo.getText().toString();
                String c = Content.getText().toString();
                if(MainActivity.token == ""){
                    Toast post_error = Toast.makeText(getApplicationContext(), "No se ah iniciado sesion", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else if(MainActivity.token == ""){
                    Toast post_error = Toast.makeText(getApplicationContext(), "No se ah especificado el grupo", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else{
                    FxyApi api = new FxyApi();
                    String msg = api.createPost(t, c, MainActivity.Group, "Fisica");
                    if(msg != "Ok"){
                        Toast post_error = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                        post_error.show();
                    }
                }
            }
        });
    }
}
