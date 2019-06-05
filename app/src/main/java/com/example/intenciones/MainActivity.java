package com.example.intenciones;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnWeb;
    Button btnGoogleMaps;
    Button btnTomarFotos;
    Button btnMandarCorreo;
    Button btnTelefonear;

    private final int MI_PERMISO_TELEFONO = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeb = findViewById(R.id.btnWeb);
        btnGoogleMaps = findViewById(R.id.btnGoogleMaps);
        btnTomarFotos = findViewById(R.id.btnMandarCorreo);
        btnMandarCorreo = findViewById(R.id.btnMandarCorreo);
        btnTelefonear = findViewById(R.id.btnTelefonear);
    }

    public void AbreWeb(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.todoturf.com"));
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Has pulsado abrir web", Toast.LENGTH_LONG).show();
    }

    public void GoogleMaps(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:43.304357, -2.016900"));
        startActivity(intent);

        Toast.makeText(MainActivity.this, "Has pulsado Google Maps", Toast.LENGTH_LONG).show();
    }

    public void TomarFotos (View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Has pulsado Tomar fotos", Toast.LENGTH_LONG).show();
    }

    public void MandarCorreo (View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
        intent.putExtra(Intent.EXTRA_TEXT, "texto del correo");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"contacto@todoturf.com"});
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Has pulsado Mandar Correo", Toast.LENGTH_LONG).show();
    }

    public void Telefonear (View view)
    {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
        {
            // Permiso
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:636964417"));
            startActivity(intent);
        }
        else
        {
            // Lanzamos un dialog para que el usuario confirme o no el permiso
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, MI_PERMISO_TELEFONO) ;
        }
        // Toast.makeText(MainActivity.this, "Has pulsado Telefonear", Toast.LENGTH_LONG).show();
    }
}