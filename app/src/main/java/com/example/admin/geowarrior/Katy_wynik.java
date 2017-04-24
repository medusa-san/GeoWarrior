package com.example.admin.geowarrior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Katy_wynik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katy_wynik);
        final TextView katy123 = (TextView)findViewById(R.id.katy123);
        final TextView katy231 = (TextView)findViewById(R.id.katy231);
        final TextView katy312 = (TextView)findViewById(R.id.katy312);
        double x1=Double.parseDouble(getIntent().getExtras().getString("X1"));
        double y1=Double.parseDouble(getIntent().getExtras().getString("Y1"));
        double x2=Double.parseDouble(getIntent().getExtras().getString("X2"));
        double y2=Double.parseDouble(getIntent().getExtras().getString("Y2"));
        double x3=Double.parseDouble(getIntent().getExtras().getString("X3"));
        double y3=Double.parseDouble(getIntent().getExtras().getString("Y3"));

        double dX12;
        double dY12;
        double k12;
        double az12;
        dX12=x2-x1;
        dY12=y2-y1;
        if (dX12==0&&dY12==0) {
            katy123.setText("Podaj prawidłowe współrzędne");
            katy231.setText("Podaj prawidłowe współrzędne");
            katy312.setText("Podaj prawidłowe współrzędne");
            return;
        }
        else if (dX12==0&&dY12<0) az12=3*Math.PI/2;
        else if (dX12==0&&dY12>0) az12=Math.PI/2;
        else if (dX12>0&&dY12>=0){
            k12=Math.atan(dY12/dX12);
            az12=k12;
        }
        else if (dX12<0&&dY12>=0){
            k12=Math.atan(dY12/dX12);
            az12=Math.PI-k12;
        }
        else if (dX12<0&&dY12<0){
            k12=Math.atan(dY12/dX12);
            az12=Math.PI+k12;
        }
        else{
            k12=Math.atan(dY12/dX12);
            az12=2*Math.PI-k12;
        }

        double dX23;
        double dY23;
        double k23;
        double az23;
        dX23=x3-x2;
        dY23=y3-y2;
        if (dX23==0&&dY23==0) {
            katy123.setText("Podaj prawidłowe współrzędne");
            katy231.setText("Podaj prawidłowe współrzędne");
            katy312.setText("Podaj prawidłowe współrzędne");
            return;
        }
        else if (dX23==0&&dY23<0) az23=3*Math.PI/2;
        else if (dX23==0&&dY23>0) az23=Math.PI/2;
        else if (dX23>0&&dY23>=0){
            k23=Math.atan(dY23/dX23);
            az23=k23;
        }
        else if (dX23<0&&dY23>=0){
            k23=Math.atan(dY23/dX23);
            az23=Math.PI-k23;
        }
        else if (dX23<0&&dY23<0){
            k23=Math.atan(dY23/dX23);
            az23=Math.PI+k23;
        }
        else{
            k23=Math.atan(dY23/dX23);
            az23=2*Math.PI-k23;
        }
        double dX31;
        double dY31;
        double k31;
        double az31;
        dX31=x1-x3;
        dY31=y1-y3;
        if (dX31==0&&dY31==0) {
            katy123.setText("Podaj prawidłowe współrzędne");
            katy231.setText("Podaj prawidłowe współrzędne");
            katy312.setText("Podaj prawidłowe współrzędne");
            return;
        }
        else if (dX31==0&&dY31<0) az31=3*Math.PI/2;
        else if (dX31==0&&dY31>0) az31=Math.PI/2;
        else if (dX31>0&&dY31>=0){
            k31=Math.atan(dY31/dX31);
            az31=k31;
        }
        else if (dX31<0&&dY31>=0){
            k31=Math.atan(dY31/dX31);
            az31=Math.PI-k31;
        }
        else if (dX31<0&&dY31<0){
            k31=Math.atan(dY31/dX31);
            az31=Math.PI+k31;
        }
        else{
            k31=Math.atan(dY31/dX31);
            az31=2*Math.PI-k31;
        }
        double k123;
        double k231;
        double k312;

        k123=az31-az12-Math.PI;
        k231=Math.PI-az23+az12;
        k312=Math.PI-az31+az23;

        katy123.setText(String.format("%.4f", k123) + " rad");
        katy231.setText(String.format("%.4f", k231) + " rad");
        katy312.setText(String.format("%.4f", k312) + " rad");
    }
}
