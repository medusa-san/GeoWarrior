package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Error extends Activity {
    Button daButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        daButton = (Button) findViewById(R.id.button);


        daButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent daIntent = new Intent(Error.this,Menu.class);
                startActivity(daIntent);
            }

        });
    }
}
