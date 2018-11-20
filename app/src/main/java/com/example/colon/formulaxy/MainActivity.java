package com.example.colon.formulaxy;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    InfoJava ij = new InfoJava();
    TextView tvParrafo = ij.tvParrafo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InfoJava ij = new InfoJava();
    }

    public void pasar (View view){
        Intent pasarLayout = new Intent(getApplicationContext(), InfoJava.class);
        startActivity(pasarLayout);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFisica:
                pasar(view);
                leer("archivos/espanol/oracion.txt");
                break;
            case R.id.btnMate:
                pasar(view);
                leer("archivos/ingles/oracion.txt");
                break;
        }
    }

    public void leer(String archive) {
        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(archive);
            String text = btoString(inputStream);
            tvParrafo.setText(text);
        } catch (IOException ex) {
            tvParrafo.setText(ex.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    tvParrafo.setText(ex.getMessage());
                }
            }
        }
    }

    public String btoString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int len = 0;
        while ((len = inputStream.read(bytes)) > 0) {
            b.write(bytes, 0, len);
        }
        return new String(b.toByteArray(), "UTF8");
    }
}