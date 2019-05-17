package com.valuepy.petagram;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_title);
        Bundle parametros = getIntent().getExtras();
        if(parametros!=null){
            TextInputEditText nombreCompleto = (TextInputEditText) findViewById(R.id.textNombreCompleto);
            nombreCompleto.setText(parametros.getCharSequence(getResources().getString(R.string.param_nombre_completo)).toString());

            DatePicker FechaDeNacimientoDP = (DatePicker) findViewById(R.id.datepicker);
            String fechaNacimiento = parametros.getCharSequence(getResources().getString(R.string.param_fechaNacimiento)).toString();
            String[] fechaDividida = fechaNacimiento.split("/");
            FechaDeNacimientoDP.updateDate(Integer.parseInt(fechaDividida[2]),Integer.parseInt(fechaDividida[0])-1,Integer.parseInt(fechaDividida[1]));
            TextInputEditText Telefono = (TextInputEditText) findViewById(R.id.textTelefono);
            Telefono.setText(parametros.getCharSequence(getResources().getString(R.string.param_Telefono)).toString());
            TextInputEditText Email = (TextInputEditText) findViewById(R.id.textEmail);
            Email.setText(parametros.getCharSequence(getResources().getString(R.string.param_Email)).toString());
            TextInputEditText Descripcion = (TextInputEditText) findViewById(R.id.textDescripcionContacto);
            Descripcion.setText(parametros.getCharSequence(getResources().getString(R.string.param_Descripcion)).toString());

        }


    }


    public void boton_siguiente(View v){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        TextView tvNombreCompleto = (TextView) findViewById(R.id.textNombreCompleto);
        intent.putExtra(getResources().getString(R.string.param_nombre_completo), tvNombreCompleto.getText());
        DatePicker datePicker = (DatePicker) findViewById(R.id.datepicker) ;
        intent.putExtra(getResources().getString(R.string.param_fechaNacimiento),datePicker.getMonth()+1+"/"+datePicker.getDayOfMonth()+"/"+
                datePicker.getYear());
        TextView tvTelefono = (TextView) findViewById(R.id.textTelefono);
        intent.putExtra(getResources().getString(R.string.param_Telefono),tvTelefono.getText());
        TextView tvEmail = (TextView) findViewById(R.id.textEmail);
        intent.putExtra(getResources().getString(R.string.param_Email),tvEmail.getText());
        TextView tvDescripcion = (TextView) findViewById(R.id.textDescripcionContacto);
        intent.putExtra(getResources().getString(R.string.param_Descripcion),tvDescripcion.getText());

        startActivity(intent);

        finish();

    }



}
