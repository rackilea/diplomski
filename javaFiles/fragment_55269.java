SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


request.addProperty("codeSession", "1234");
request.addProperty("type","CLIENT");
request.addProperty("client_number","167");
request.addProperty("account_num","3403");
request.addProperty("codeAuth","333");

Log.e("Soap Request : ", "" + request);

SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
envelope.dotNet = true;
envelope.setOutputSoapObject(request);

HttpTransportSE aht = new HttpTransportSE(URL);

try

{
    aht.call(SOAP_ACTION, envelope);
    SoapObject response = (SoapObject) envelope.getResponse();

    Log.e ("login result", response.toString()); //lblResult.setText(results.toString());

    Boolean loginStatus = Boolean.getBoolean(response.getProperty("success").toString());

}