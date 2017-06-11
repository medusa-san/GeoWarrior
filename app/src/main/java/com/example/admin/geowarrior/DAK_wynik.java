package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import java.lang.String;
import java.util.InputMismatchException;

public class DAK_wynik extends Activity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dak_wynik);

        try {
            final TextView dlugosc1 = (TextView) findViewById(R.id.dlugosc);
            final TextView azymut12r = (TextView) findViewById(R.id.azymut12_rad);
            final TextView azymut12g = (TextView) findViewById(R.id.azymut12_grad);
            final TextView azymut12s = (TextView) findViewById(R.id.azymut12_st);
            final TextView azymut21r = (TextView) findViewById(R.id.azymut21_rad);
            final TextView azymut21g = (TextView) findViewById(R.id.azymut21_grad);
            final TextView azymut21s = (TextView) findViewById(R.id.azymut21_st);

            double x1 = Double.parseDouble(getIntent().getExtras().getString("X1"));
            double y1 = Double.parseDouble(getIntent().getExtras().getString("Y1"));
            double x2 = Double.parseDouble(getIntent().getExtras().getString("X2"));
            double y2 = Double.parseDouble(getIntent().getExtras().getString("Y2"));

            double d;
            d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

            double dX12;
            double dY12;
            double k12;
            double az12;
            dX12 = x2 - x1;
            dY12 = y2 - y1;
            if (dX12 == 0 && dY12 == 0) {
                Intent daIntent = new Intent(DAK_wynik.this,Error.class);
                startActivity(daIntent);
                azymut12r.setText("Błąd");
                azymut21r.setText("Błąd");
                return;
            } else if (dX12 == 0 && dY12 < 0) az12 = 3 * Math.PI / 2;
            else if (dX12 == 0 && dY12 > 0) az12 = Math.PI / 2;
            else if (dX12 > 0 && dY12 >= 0) {
                k12 = Math.atan(dY12 / dX12);
                az12 = k12;
            } else if (dX12 < 0 && dY12 >= 0) {
                k12 = Math.atan(dY12 / (-dX12));
                az12 = Math.PI - k12;
            } else if (dX12 < 0 && dY12 < 0) {
                k12 = Math.atan(dY12 / dX12);
                az12 = Math.PI + k12;
            } else {
                k12 = Math.atan(-dY12 / dX12);
                az12 = 2 * Math.PI - k12;
            }

            if(az12<0) az12+=2*Math.PI;
            if(az12>=2*Math.PI) az12-=2*Math.PI;

            double az21;
            double az21g;
            double az21s;
            double az12g;
            double az12s;

            az12g = az12 * 200 / Math.PI;
            az12s = az12 * 180 / Math.PI;
            if (az12 <= Math.PI) {
                az21 = az12 + Math.PI;
                az21g = az12g + 200;
                az21s = az12s + 180;
            } else {
                az21 = 2 * Math.PI - az12;
                az21g = 400 - az12g;
                az21s = 360 - az12s;
            }

            dlugosc1.setText(String.format("%.4f", d) + " m");

            azymut12r.setText(String.format("%.4f", az12) + " rad");
            azymut21r.setText(String.format("%.4f", az21) + " rad");
            azymut12g.setText(String.format("%.4f", az12g) + "grad");
            azymut21g.setText(String.format("%.4f", az21g) + " grad");
            azymut12s.setText(String.format("%.4f", az12s) + "\u00b0");
            azymut21s.setText(String.format("%.4f", az21s) + "\u00b0");
        }
        catch(Exception e){
            Intent daIntent = new Intent(DAK_wynik.this,Error.class);
            startActivity(daIntent);
        }

    }
}
