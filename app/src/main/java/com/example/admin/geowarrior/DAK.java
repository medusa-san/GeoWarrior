package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DAK extends Activity {

    Button mButton;
    EditText xX1;
    EditText xX2;
    EditText yY1;
    EditText yY2;

    /*public DAK () {
        x1=x1();
        y1=y1();
        x2=x2();
        y2=y2();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dak);

        mButton = (Button)findViewById(R.id.button);
        xX1   = (EditText)findViewById(R.id.xX1);
        xX2   = (EditText)findViewById(R.id.xX2);
        yY1   = (EditText)findViewById(R.id.yY1);
        yY2   = (EditText)findViewById(R.id.yY2);


        mButton.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(DAK.this,DAK_wynik.class);
                        intent.putExtra("X1",xX1.getText().toString());
                        intent.putExtra("Y1",yY1.getText().toString());
                        intent.putExtra("X2",xX2.getText().toString());
                        intent.putExtra("Y2",yY2.getText().toString());
                        startActivity(intent);
                    }

                });
    }






}
