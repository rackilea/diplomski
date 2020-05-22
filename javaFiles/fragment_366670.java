package com.example.clientnetpositionreport;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class GetReport extends Activity {
    private static final String NAMESPACE = "http://tempuri.org/"; // com.service.ServiceImpl
    private static final String URL = "http://commodities.karvy.com/services/NetPositionReport.asmx";
    private static final String METHOD_NAME = "NetPositionReport";
    private static final String SOAP_ACTION = "http://tempuri.org/NetPositionReport";
    private String webResponse = "";
    private Handler handler = new Handler();
    private Thread thread;

    private TextView textView1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(R.layout.fragment_item_detail);
        textView1 = (TextView) findViewById(R.id.item_detail);

        String title= getIntent().getExtras().getString("ClientCode");

        System.out.println("Data is " + title);

        startWebAccess(title);

    }

    public void startWebAccess(String a) {
        final String aa = a;
        thread = new Thread() {
            public void run() {
                try {
                    Log.d("Req value0R", "Starting...");
                    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                    // simple object access protocol
                    request.addProperty("ClientCode", aa);
                    request.addProperty("key", "Om$@!#@M^#R");

                    Log.d("Req value1", request.toString());

                    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
                    envelope.dotNet = true;
                    envelope.bodyOut = request;
                    // envelope.dotNet = true;
                    envelope.setOutputSoapObject(request);

                    Log.d("Req value2", envelope.toString());

                    androidHttpTransport.debug = true;
                    androidHttpTransport.call(SOAP_ACTION, envelope);

                    SoapObject resultData = (SoapObject) envelope.getResponse();
                    if (resultData != null)
                        webResponse = resultData.toString();
                    else
                        webResponse = "No Data found.";
                    System.out.println("webResponse : " + webResponse);

                }

                catch (Exception e) {
                    e.printStackTrace();
                    webResponse = "Connection/Internet problem";
                }
                handler.post(createUI);
            }
        };
        thread.start();
    }

    final Runnable createUI = new Runnable() {

        public void run() {
            if (webResponse != null) {
                textView1.setText(webResponse);
            } else {
                webResponse = "No data provided presently";
                textView1.setText(webResponse);
            }
        }
    };

}