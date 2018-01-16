package fr.m2i.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.FileOutputStream;

import static fr.m2i.services.Tools.showNotification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demarrerService(View v){
        Intent i = new Intent(this, Service1.class);
        startService(i);

    }
}
