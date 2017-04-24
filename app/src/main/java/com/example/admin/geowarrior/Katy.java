package com.example.admin.geowarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Katy extends AppCompatActivity {
    Button mButton;
    EditText xX1;
    EditText xX2;
    EditText yY1;
    EditText yY2;
    EditText xX3;
    EditText yY3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katy);
        mButton = (Button) findViewById(R.id.button);
        xX1 = (EditText) findViewById(R.id.xX1);
        xX2 = (EditText) findViewById(R.id.xX2);
        xX3 = (EditText) findViewById(R.id.xX3);
        yY1 = (EditText) findViewById(R.id.yY1);
        yY2 = (EditText) findViewById(R.id.yY2);
        yY3 = (EditText) findViewById(R.id.yY3);


        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Katy.this, Katy_wynik.class);
                intent.putExtra("X1", xX1.getText().toString());
                intent.putExtra("Y1", yY1.getText().toString());
                intent.putExtra("X2", xX2.getText().toString());
                intent.putExtra("Y2", yY2.getText().toString());
                intent.putExtra("X3", xX3.getText().toString());
                intent.putExtra("Y3", yY3.getText().toString());
                startActivity(intent);
            }

        });
    }
}
