package com.example.admin.geowarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = new Intent(Menu.this,DAK.class);
        //intent.putExtra("tt1",xX1.getText().toString());
        startActivity(intent);
    }
}
