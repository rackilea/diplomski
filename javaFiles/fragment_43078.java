package com.example.tmp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    Timer timeoutTimer;
    final Random myRandom = new Random();
    GenerateTask genTask = new GenerateTask();
    final ArrayList<Object> arry1 = new ArrayList<Object>();

    class GenerateTask extends TimerTask {
        boolean started = false;
        @Override
        public void run() {
            if (started) {
                System.out.println("generating");
                final TextView textGenerateNumber = (TextView)findViewById(R.id.generatenumber);
                arry1.clear();
                for(int i=0;i<1;i++){
                    ArrayList<Integer> Arry = new ArrayList<Integer>();
                    for(int k=0;k<7;k++){
                        Arry.add(myRandom.nextInt(10));
                    }
                    arry1.add(Arry);
                }
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        textGenerateNumber.setText(String.valueOf(arry1));
                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
        Button buttonGenerate = (Button)findViewById(R.id.generateme);

        buttonGenerate.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("click");
                if (!genTask.started) {
                    genTask.started=true;
                    timeoutTimer = new Timer();
                    timeoutTimer.scheduleAtFixedRate(genTask, 0, 30000);
                } else {
                    genTask.started=false;
                    timeoutTimer.cancel();
                }
            }
        });  
    }
}