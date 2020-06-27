package com.mata.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnCurrentlyReading;
    private Button btnSeeAll;
    private Button btnAlreadyRead;
    private Button btnWantRead;
    private Button btnFavs;
    private Button btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AllBookActivity.class));
            }
        });
    }

    private void initViews() {
        btnAbout = findViewById(R.id.btnAbout);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnSeeAll = findViewById(R.id.btnAllBooks);
        btnWantRead = findViewById(R.id.btnWantTRead);
        btnFavs = findViewById(R.id.btnFavourites);
    }


}
