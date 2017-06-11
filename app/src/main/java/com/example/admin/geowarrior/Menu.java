package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {
    Button daButton;
    Button kButton;
    Button wButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        daButton = (Button) findViewById(R.id.dl_az);
        kButton = (Button) findViewById(R.id.katy);
        wButton = (Button) findViewById(R.id.wciecia);

        daButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent daIntent = new Intent(Menu.this,DAK.class);
                startActivity(daIntent);
            }

        });
        kButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent kIntent = new Intent(Menu.this,Katy.class);
                startActivity(kIntent);
            }

        });
        wButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent wIntent = new Intent(Menu.this,Wciecia.class);
                startActivity(wIntent);
            }

        });
    }
}
