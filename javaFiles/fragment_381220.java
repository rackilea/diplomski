@Override
    protected Void doInBackground(Void... arg0) {
        try {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            HttpTransportSE httpTransport = new HttpTransportSE(URL);
            //httpTransport.debug = true;
            httpTransport.call(SOAP_ACTION, envelope);
            SoapPrimitive result =(SoapPrimitive)envelope.bodyIn;
            Log.d("App", "" + result.toString());
            response = result.toString();
        } catch (IOException | XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  //send request
        return null;
    }
}