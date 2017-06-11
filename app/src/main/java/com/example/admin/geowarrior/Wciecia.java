package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Wciecia extends Activity {

    Button lButton;
    Button kButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wciecia);
        lButton = (Button) findViewById(R.id.lin);
        kButton = (Button) findViewById(R.id.kat);


        lButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent lIntent = new Intent(Wciecia.this,W_lin.class);
                startActivity(lIntent);
            }

        });
        kButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent kIntent = new Intent(Wciecia.this,W_kat.class);
                startActivity(kIntent);
            }

        });

    }
}
