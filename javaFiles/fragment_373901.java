package com.example.howtosendsmsinandroid;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.os.Handler;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Map;
import android.content.BroadcastReceiver;
import android.content.Context;

public class MainActivity extends Activity {
/*
    EditText txtPhoneNo;

    EditText txttime;

 */
    //AsyncTask<?, ?, ?> runningTask;
    EditText txtMessage;
    Button btnSend;
    Button btnLoad;
    String p = Manifest.permission.SEND_SMS;
    ProgressDialog barraProgreso;
    private Hashtable<Integer, ArrayList<String>> contacts = new Hashtable<Integer, ArrayList<String>>();
    int i = 0;
    private Handler handler;
    BroadcastReceiver smsSentReceiver, smsDeliveredReceiver;
    public void onResume() {
        super.onResume();
        smsSentReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                // TODO Auto-generated method stub
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS has been sent", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic Failure", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No Service", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio Off", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

            }
        };
        smsDeliveredReceiver=new BroadcastReceiver() {

            @Override
            public void onReceive(Context arg0, Intent arg1) {
                // TODO Auto-generated method stub
                switch(getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS Delivered", Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SMS not delivered", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        registerReceiver(smsSentReceiver, new IntentFilter("SMS_SENT"));
        registerReceiver(smsDeliveredReceiver, new IntentFilter("SMS_DELIVERED"));
    }

    public void onPause() {
        super.onPause();
        unregisterReceiver(smsSentReceiver);
        unregisterReceiver(smsDeliveredReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //txtPhoneNo = (EditText) this.findViewById(R.id.nrotelf);
        //txtMessage = (EditText) this.findViewById(R.id.editText2);
        //txttime = (EditText) this.findViewById(R.id.editText);
        txtMessage =  this.findViewById(R.id.txtMessage);
        btnSend =  this.findViewById(R.id.btn);
        btnLoad = this.findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String linea;
                    InputStream fraw =
                            getResources().openRawResource(R.raw.numbers);

                    BufferedReader brin =
                            new BufferedReader(new InputStreamReader(fraw));
                    int count = 0;
                    while ((linea = brin.readLine()) != null) {
                        //NO ENVIA SI SON 160 O MAS CARACTERES (DE FORMA ORDINARIA)

                        String[] parts = linea.split(";");
                        contacts.get(count);
                        ArrayList<String> numbers = new ArrayList<String>();
                        numbers.add(parts[0]);
                        //numbers.add(parts[1]);
                        //numbers.add(parts[2]);
                        contacts.put(count, numbers);
                        count++;


                    }
                    Toast.makeText(getBaseContext(), "Numeros importados: " + contacts.size(), Toast.LENGTH_LONG).show();
                }catch (Exception ex)
                {
                    Log.e("Ficheros", "Error al leer fichero desde recurso raw");
                }
            }
        });
        btnSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener numero de telefono y mensaje
                checkSMSStatePermission();

                try {


                    barraProgreso = new ProgressDialog(MainActivity.this);
                    barraProgreso.setTitle("Buscando...");
                    barraProgreso.setMessage("Progreso...");
                    barraProgreso.setProgressStyle(barraProgreso.STYLE_HORIZONTAL);
                    barraProgreso.setProgress(0);
                    barraProgreso.setMax(contacts.size());
                    barraProgreso.show();

                    handler = new Handler();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (barraProgreso.getProgress() <= barraProgreso.getMax()) {
                                    Thread.sleep(10000);
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            sendMessage();
                                            barraProgreso.incrementProgressBy(1);
                                            i++;
                                        }
                                    });

                                    if(barraProgreso.getProgress() == barraProgreso.getMax()){
                                        barraProgreso.dismiss();
                                    }
                                }
                            }catch (InterruptedException er){
                                er.printStackTrace();
                            }
                        }
                    }).start();


                    // If phone number & message is not empty

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    // Function send message sms
    private void sendMessage() {
        SmsManager smsManager = SmsManager.getDefault();
        PendingIntent sentPI;
        String SENT = "SMS_SENT";
        //String message = "Mensaje de prueba: " + i;

        //String message = "Hola "+ contacts.get(i).get(1)+" , le informamos que su "+ contacts.get(i).get(2)+" se ha comido a su vecina. Contacte con nosotros a traves de www.porncharacters.com";
        String message = txtMessage.getText().toString();

        //el primer parametro recibe el contexto asi que lo
        // llamas desde un fragment tendras
        //cambiar el this por getContext()
        sentPI = PendingIntent.getBroadcast(getBaseContext(), 0, new Intent(SENT), 0);
        smsManager.sendTextMessage(contacts.get(i).get(0), null, message, sentPI, null);
        //Toast.makeText(getBaseContext(), message.length(), Toast.LENGTH_LONG).show();

    }

    private void checkSMSStatePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para enviar SMS.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para enviar SMS!");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
}