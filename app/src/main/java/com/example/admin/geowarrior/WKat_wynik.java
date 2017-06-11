package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WKat_wynik extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wkat_wynik);

        try {
            final TextView xW = (TextView) findViewById(R.id.xX);
            final TextView yW = (TextView) findViewById(R.id.yY);

            double xA = Double.parseDouble(getIntent().getExtras().getString("X1"));
            double yA = Double.parseDouble(getIntent().getExtras().getString("Y1"));
            double xB = Double.parseDouble(getIntent().getExtras().getString("X2"));
            double yB = Double.parseDouble(getIntent().getExtras().getString("Y2"));
            double alfaG = Double.parseDouble(getIntent().getExtras().getString("K1W"));
            double betaG = Double.parseDouble(getIntent().getExtras().getString("K2W"));

            double c;
            c = Math.sqrt((xA-xB)*(xA-xB)+(yA-yB)*(yA-yB));
            double dXAB;
            double dYAB;
            double k12;
            double azAB;
            dXAB = xB - xA;
            dYAB = yB - yA;
            if (dXAB == 0 && dYAB == 0) {
                Intent daIntent = new Intent(WKat_wynik.this,Error.class);
                startActivity(daIntent);
                xW.setText("Błąd");
                yW.setText("Błąd");
                return;
            } else if (dXAB == 0 && dYAB < 0) azAB = 3 * Math.PI / 2;
            else if (dXAB == 0 && dYAB > 0) azAB = Math.PI / 2;
            else if (dXAB > 0 && dYAB >= 0) {
                k12 = Math.atan(dYAB / dXAB);
                azAB = k12;
            } else if (dXAB < 0 && dYAB >= 0) {
                k12 = Math.atan(dYAB / (-dXAB));
                azAB = Math.PI - k12;
            } else if (dXAB < 0 && dYAB < 0) {
                k12 = Math.atan(dYAB / dXAB);
                azAB = Math.PI + k12;
            } else {
                k12 = Math.atan(-dYAB / dXAB);
                azAB = 2 * Math.PI - k12;
            }

            if(azAB<0) azAB+=2*Math.PI;
            if(azAB>=2*Math.PI) azAB-=2*Math.PI;

            double azBA;
            if (azAB <= Math.PI) {
                azBA = azAB + Math.PI;
            } else {
                azBA = 2 * Math.PI - azAB;
            }

            double alfa,beta,azAW,azBW;
            alfa=alfaG*Math.PI/200;
            beta=betaG*Math.PI/200;
            azAW=azAB-alfa;
            azBW=azBA+beta;

            double a,b;
            a=c*Math.sin(alfa)/Math.sin(alfa+beta);
            b=c*Math.sin(beta)/Math.sin(alfa+beta);

            double dXAW,dYAW,dXBW,dYBW;
            dXAW=b*Math.cos(azAW);
            dYAW=b*Math.sin(azAW);
            dXBW=a*Math.cos(azBW);
            dYBW=a*Math.sin(azBW);

            double xW1,xW2,yW1,yW2;
            xW1=xA+dXAW;
            yW1=yA+dYAW;
            xW2=xB+dXBW;
            yW2=yB+dYBW;

            if (((xW1-xW2<0.01)||(xW2-xW2<0.01))&&((yW1-yW2<0.01)||(yW2-yW2<0.01))){
                xW.setText(String.format("%.4f", xW1) + " m");
                yW.setText(String.format("%.4f", yW1) + " m");
            }
            else {
                Intent daIntent = new Intent(WKat_wynik.this, Error.class);
                startActivity(daIntent);
                xW.setText("Błąd");
                yW.setText("Błąd");
            }
        }
        catch(Exception e){
            Intent daIntent = new Intent(WKat_wynik.this,Error.class);
            startActivity(daIntent);
        }
    }
}
