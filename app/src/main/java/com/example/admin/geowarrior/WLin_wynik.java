package com.example.admin.geowarrior;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WLin_wynik extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wlin_wynik);

        try {
            final TextView xW = (TextView) findViewById(R.id.xX);
            final TextView yW = (TextView) findViewById(R.id.yY);

            double xA = Double.parseDouble(getIntent().getExtras().getString("X1"));
            double yA = Double.parseDouble(getIntent().getExtras().getString("Y1"));
            double xB = Double.parseDouble(getIntent().getExtras().getString("X2"));
            double yB = Double.parseDouble(getIntent().getExtras().getString("Y2"));
            double b = Double.parseDouble(getIntent().getExtras().getString("D1W"));
            double a = Double.parseDouble(getIntent().getExtras().getString("D2W"));

            double c;
            c = Math.sqrt((xA-xB)*(xA-xB)+(yA-yB)*(yA-yB));

            double cA,cB,cC;
            cA=-a*a+b*b+c*c;
            cB=a*a-b*b+c*c;
            cC=a*a+b*b-c*c;

            double p4=Math.sqrt(cA*cB+cA*cC+cB*cC);
            if ((cA+cB!=0)&&(a+b>c)&&(b+c>a)&&(a+c>b)){
                double x,y;
                x=(xA*cB+yA*p4+xB*cA-yB*p4)/(cA+cB);
                y=(-xA*p4+yA*cB+xB*p4+yB*cA)/(cA+cB);
                xW.setText(String.format("%.4f", x) + " m");
                yW.setText(String.format("%.4f", y) + " m");
            }
            else{
                Intent daIntent = new Intent(WLin_wynik.this,Error.class);
                startActivity(daIntent);
                xW.setText("Błąd");
                yW.setText("Błąd");
            }
        }
        catch(Exception e){
            Intent daIntent = new Intent(WLin_wynik.this,Error.class);
            startActivity(daIntent);
        }
    }
}
