package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Katy_wynik extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katy_wynik);

        try {
            final TextView katy123 = (TextView) findViewById(R.id.katy123);
            final TextView katy231 = (TextView) findViewById(R.id.katy231);
            final TextView katy312 = (TextView) findViewById(R.id.katy312);
            final TextView katy123_g = (TextView) findViewById(R.id.katy123_g);
            final TextView katy231_g = (TextView) findViewById(R.id.katy231_g);
            final TextView katy312_g = (TextView) findViewById(R.id.katy312_g);
            final TextView katy123_s = (TextView) findViewById(R.id.katy123_s);
            final TextView katy231_s = (TextView) findViewById(R.id.katy231_s);
            final TextView katy312_s = (TextView) findViewById(R.id.katy312_s);
            double x1 = Double.parseDouble(getIntent().getExtras().getString("X1"));
            double y1 = Double.parseDouble(getIntent().getExtras().getString("Y1"));
            double x2 = Double.parseDouble(getIntent().getExtras().getString("X2"));
            double y2 = Double.parseDouble(getIntent().getExtras().getString("Y2"));
            double x3 = Double.parseDouble(getIntent().getExtras().getString("X3"));
            double y3 = Double.parseDouble(getIntent().getExtras().getString("Y3"));

            double dX12;
            double dY12;
            double k12;
            double az12;
            dX12 = x2 - x1;
            dY12 = y2 - y1;
            if (dX12 == 0 && dY12 == 0) {
                katy123.setText("Błąd");
                katy231.setText("Błąd");
                katy312.setText("Błąd");
                return;
            } else if (dX12 == 0 && dY12 < 0) az12 = 3 * Math.PI / 2;
            else if (dX12 == 0 && dY12 > 0) az12 = Math.PI / 2;
            else if (dX12 > 0 && dY12 >= 0) {
                k12 = Math.atan(dY12 / dX12);
                az12 = k12;
            } else if (dX12 < 0 && dY12 >= 0) {
                k12 = Math.atan(-dY12 / dX12);
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

            double dX23;
            double dY23;
            double k23;
            double az23;
            dX23 = x3 - x2;
            dY23 = y3 - y2;
            if (dX23 == 0 && dY23 == 0) {
                katy123.setText("Błąd");
                katy231.setText("Błąd");
                katy312.setText("Błąd");
                return;
            } else if (dX23 == 0 && dY23 < 0) az23 = 3 * Math.PI / 2;
            else if (dX23 == 0 && dY23 > 0) az23 = Math.PI / 2;
            else if (dX23 > 0 && dY23 >= 0) {
                k23 = Math.atan(dY23 / dX23);
                az23 = k23;
            } else if (dX23 < 0 && dY23 >= 0) {
                k23 = Math.atan(-dY23 / dX23);
                az23 = Math.PI - k23;
            } else if (dX23 < 0 && dY23 < 0) {
                k23 = Math.atan(dY23 / dX23);
                az23 = Math.PI + k23;
            } else {
                k23 = Math.atan(-dY23 / dX23);
                az23 = 2 * Math.PI - k23;
            }

            if(az23<0) az23+=2*Math.PI;
            if(az23>=2*Math.PI) az23-=2*Math.PI;

            double dX31;
            double dY31;
            double k31;
            double az31;
            dX31 = x1 - x3;
            dY31 = y1 - y3;
            if (dX31 == 0 && dY31 == 0) {
                katy123.setText("Błąd");
                katy231.setText("Błąd");
                katy312.setText("Błąd");
                return;
            } else if (dX31 == 0 && dY31 < 0) az31 = 3 * Math.PI / 2;
            else if (dX31 == 0 && dY31 > 0) az31 = Math.PI / 2;
            else if (dX31 > 0 && dY31 >= 0) {
                k31 = Math.atan(dY31 / dX31);
                az31 = k31;
            } else if (dX31 < 0 && dY31 >= 0) {
                k31 = Math.atan(-dY31 / dX31);
                az31 = Math.PI - k31;
            } else if (dX31 < 0 && dY31 < 0) {
                k31 = Math.atan(dY31 / dX31);
                az31 = Math.PI + k31;
            } else {
                k31 = Math.atan(-dY31 / dX31);
                az31 = 2 * Math.PI - k31;
            }

            if(az31<0) az31+=2*Math.PI;
            if(az31>=2*Math.PI) az31-=2*Math.PI;


            double k123;
            double k231;
            double k312;

            k123 = Math.abs(az12-Math.PI) - az23;
            k231 = Math.abs(az23-Math.PI) - az31;
            k312 = Math.abs(az31-Math.PI) - az12;

            if (k123 < 0) {
                k123 =-k123;
            }
            if (k123 > (Math.PI)) {
                k123 -= (Math.PI);
            }
            if (k231 < 0) {
                k231 =-k231;
            }
            if (231 > (Math.PI)) {
                k231 -= (Math.PI);
            }
            if (k312 < 0) {
                k312 =-k312;
            }
            if (k312 > (Math.PI)) {
                k312 -= Math.PI;
            }


            double k123g, k123s, k231g, k231s, k312g, k312s;
            k123g = k123 * 200 / Math.PI;
            k123s = k123 * 180 / Math.PI;
            k231g = k231 * 200 / Math.PI;
            k231s = k231 * 180 / Math.PI;
            k312g = k312 * 200 / Math.PI;
            k312s = k312 * 180 / Math.PI;

            katy123.setText(String.format("%.4f", k123) + " rad");
            katy231.setText(String.format("%.4f", k231) + " rad");
            katy312.setText(String.format("%.4f", k312) + " rad");
            katy123_g.setText(String.format("%.4f", k123g) + " grad");
            katy231_g.setText(String.format("%.4f", k231g) + " grad");
            katy312_g.setText(String.format("%.4f", k312g) + " grad");
            katy123_s.setText(String.format("%.4f", k123s) + "\u00b0");
            katy231_s.setText(String.format("%.4f", k231s) + "\u00b0");
            katy312_s.setText(String.format("%.4f", k312s) + "\u00b0");
        }
        catch(Exception e){
            Intent daIntent = new Intent(Katy_wynik.this,Error.class);
            startActivity(daIntent);
        }
    }
}
