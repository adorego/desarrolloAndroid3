package com.valuepy.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG="MiAPP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.toolbar_title);
        Bundle parametros = getIntent().getExtras();
        if(parametros!=null){
            TextView nombreCompleto = (TextView) findViewById(R.id.tvNombreCompleto);
            nombreCompleto.setText(parametros.getCharSequence(getResources().getString(R.string.param_nombre_completo)).toString());
            TextView FechaDeNacimiento = (TextView) findViewById(R.id.tvFechaDeNacimiento);
            FechaDeNacimiento.setText("Fecha de Nacimiento:"+ parametros.getCharSequence(getResources().getString(R.string.param_fechaNacimiento)).toString());
            TextView Telefono = (TextView) findViewById(R.id.tvTelefono);
            Telefono.setText("Telefono:" + parametros.getCharSequence(getResources().getString(R.string.param_Telefono)).toString());
            TextView Email = (TextView) findViewById(R.id.tvEmail);
            Email.setText("Email:" + parametros.getCharSequence(getResources().getString(R.string.param_Email)).toString());
            TextView Descripcion = (TextView) findViewById(R.id.tvDescripcion);
            Descripcion.setText("Descripcion:" + parametros.getCharSequence(getResources().getString(R.string.param_Descripcion)).toString());

        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(DetailsActivity.this, MainActivity.class);


            startActivity(intent);

        }
        return super.onKeyDown(keyCode, event);
    }

    public void editar(View v){
        Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
        TextView nombreCompleto = (TextView) findViewById(R.id.tvNombreCompleto);
        intent.putExtra(getResources().getString(R.string.param_nombre_completo), nombreCompleto.getText());
        TextView FechaDeNacimiento = (TextView) findViewById(R.id.tvFechaDeNacimiento);
        String fechaNacimientoTexto = FechaDeNacimiento.getText().toString().split(":")[1];
        intent.putExtra(getResources().getString(R.string.param_fechaNacimiento), fechaNacimientoTexto);
        TextView Telefono = (TextView) findViewById(R.id.tvTelefono);
        intent.putExtra(getResources().getString(R.string.param_Telefono),Telefono.getText().toString().split(":")[1]);

        TextView Email = (TextView) findViewById(R.id.tvEmail);
        intent.putExtra(getResources().getString(R.string.param_Email),Email.getText().toString().split(":")[1]);

        TextView Descripcion = (TextView) findViewById(R.id.tvDescripcion);
        intent.putExtra(getResources().getString(R.string.param_Descripcion),Descripcion.getText().toString().split(":")[1]);

        startActivity(intent);

    }
}
