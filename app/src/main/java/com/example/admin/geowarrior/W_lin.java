package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class W_lin extends Activity {
    Button mButton;
    EditText xX1;
    EditText xX2;
    EditText yY1;
    EditText yY2;
    EditText d1W;
    EditText d2W;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_lin);
        mButton = (Button) findViewById(R.id.button);
        xX1 = (EditText) findViewById(R.id.xX1);
        xX2 = (EditText) findViewById(R.id.xX2);
        d1W = (EditText) findViewById(R.id.d1W);
        yY1 = (EditText) findViewById(R.id.yY1);
        yY2 = (EditText) findViewById(R.id.yY2);
        d2W = (EditText) findViewById(R.id.d2W);


        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(W_lin.this, WLin_wynik.class);
                intent.putExtra("X1", xX1.getText().toString());
                intent.putExtra("Y1", yY1.getText().toString());
                intent.putExtra("X2", xX2.getText().toString());
                intent.putExtra("Y2", yY2.getText().toString());
                intent.putExtra("D1W", d1W.getText().toString());
                intent.putExtra("D2W", d2W.getText().toString());
                startActivity(intent);
            }

        });
    }
}
