package com.example.colon.formulaxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoJava extends AppCompatActivity {

    TextView tvParrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        tvParrafo = findViewById(R.id.tvParagraph);

        //recibirDatos();
    }

}
