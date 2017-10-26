package com.example.kovacszoltan.rock_scissors_paper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {
    private Button btn_ko;
    private Button btn_ollo;
    private Button btn_papir;
    private TextView eredmeny;
    private ImageView ember;
    private ImageView robot;
    private int ember_pont = 0;
    private int robot_pont = 0;
    private int gep_valasztasa;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ko = (Button) findViewById(R.id.btn_ko);
        btn_ollo = (Button) findViewById(R.id.btn_ollo);
        btn_papir = (Button) findViewById(R.id.btn_papir);
        eredmeny = (TextView) findViewById(R.id.textView_eredmeny);
        ember = (ImageView) findViewById(R.id.imageView_ember);
        robot = (ImageView) findViewById(R.id.imageView_robot);

        btn_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gep_valasztasa = r.nextInt(3) + 1;
                ember.setBackgroundResource(R.drawable.rock);
                switch(gep_valasztasa){
                    case 1:
                        robot.setBackgroundResource(R.drawable.rock);
                        Toast toast=Toast.makeText(getApplicationContext(),"A két kő egyenlően erős",Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case 2:
                        robot.setBackgroundResource(R.drawable.paper);
                        ember_pont--;
                        Toast toastpaper=Toast.makeText(getApplicationContext(),"A papír erősebb a kőnél.",Toast.LENGTH_SHORT);
                        toastpaper.show();
                        break;
                    case 3:
                        robot.setBackgroundResource(R.drawable.scissors);
                        robot_pont++;
                        Toast toastollo=Toast.makeText(getApplicationContext(),"A kő erősebb az ollónál",Toast.LENGTH_SHORT);
                        toastollo.show();
                        break;
                }
                eredmeny.setText("Eredmény: Ember: " + String.valueOf(ember_pont) + " Computer: " + String.valueOf(robot_pont));
            }
        });
        btn_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gep_valasztasa = r.nextInt(3) + 1;
                ember.setBackgroundResource(R.drawable.scissors);
                eredmeny.setText(String.valueOf(ember_pont) + ':' + String.valueOf(robot_pont));
                switch(gep_valasztasa){
                    case 1:
                        robot.setBackgroundResource(R.drawable.rock);
                        robot_pont--;
                        Toast toastkoollo=Toast.makeText(getApplicationContext(),"A kő erősebb az ollónál",Toast.LENGTH_SHORT);
                        toastkoollo.show();
                        break;
                    case 2:
                        robot.setBackgroundResource(R.drawable.paper);
                        ember_pont++;
                        Toast toastollopapir=Toast.makeText(getApplicationContext(),"Az olló erősebb a papírnál",Toast.LENGTH_SHORT);
                        toastollopapir.show();
                        break;
                    case 3:
                        robot.setBackgroundResource(R.drawable.scissors);
                        Toast toast=Toast.makeText(getApplicationContext(),"A két olló egyenlően erős",Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                }
                eredmeny.setText("Eredmény: Ember: " + String.valueOf(ember_pont) + " Computer: " + String.valueOf(robot_pont));
            }
        });
        btn_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gep_valasztasa = r.nextInt(3) + 1;
                ember.setBackgroundResource(R.drawable.paper);
                eredmeny.setText(String.valueOf(ember_pont) + ':' + String.valueOf(robot_pont));
                switch(gep_valasztasa){
                    case 1:
                        robot.setBackgroundResource(R.drawable.rock);
                        ember_pont++;
                        Toast toast=Toast.makeText(getApplicationContext(),"A papír erősebb a kőnél",Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case 2:
                        robot.setBackgroundResource(R.drawable.paper);
                        Toast toastpapir=Toast.makeText(getApplicationContext(),"A két papir egyenlően erős",Toast.LENGTH_SHORT);
                        toastpapir.show();
                        break;
                    case 3:
                        robot.setBackgroundResource(R.drawable.scissors);
                        robot_pont--;
                        Toast toastollo=Toast.makeText(getApplicationContext(),"Az olló erősebb a papírnál",Toast.LENGTH_SHORT);
                        toastollo.show();
                        break;
                }
                eredmeny.setText("Eredmény: Ember: " + String.valueOf(ember_pont) + " Computer: " + String.valueOf(robot_pont));
            }
        });

    }
}
