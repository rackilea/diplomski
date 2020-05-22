import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.content.Context;
import android.os.AsyncTask;

public class MyTask extends AsyncTask<String, Integer, String> {
    private AsyncTaskCompleteListener callback;

    public MyTask(Context context, MainActivity mainActivity) {
        // TODO Auto-generated constructor stub
        callback = mainActivity;
    }

    private static final String SOAP_ACTION = "http://www.w3schools.com/webservices/CelsiusToFahrenheit";
    private static final String OPERATION_NAME = "CelsiusToFahrenheit";
    private static final String NAMESPACE = "http://www.w3schools.com/webservices/";
    private static final String URL = "http://www.w3schools.com/webservices/tempconvert.asmx?WSDL";

    @Override
    protected String doInBackground(String... params) {
        String response = null;
        SoapObject Request = new SoapObject(NAMESPACE, OPERATION_NAME);
        Request.addProperty("Celsius", "1");

        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(Request);

        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        androidHttpTransport.debug = true;
        // this is the actual part that will call the webservice
        try {
            androidHttpTransport.call(SOAP_ACTION, soapEnvelope);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Get the SoapResult from the envelope body.
        SoapObject result = (SoapObject) soapEnvelope.bodyIn;
        response = result.getProperty(0).toString();
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        callback.onTaskComplete(result);
        super.onPostExecute(result);
    }
}