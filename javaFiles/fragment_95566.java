SoapObject request = new SoapObject(WEBSERVICE_NAMESPACE, methodName);
    if(null != parameterMap && !parameterMap.isEmpty()){
        for(Entry<String, String> entry: parameterMap.entrySet()){
            request.addProperty(entry.getKey(), entry.getValue());
        }
    }
    // Declare the version of the SOAP request

    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.implicitTypes = true;
    envelope.dotNet = true;
    envelope.setOutputSoapObject(request);


    HttpTransportSE androidHttpTransport = new HttpTransportSE(ApplicationConstants.WEBSERVICE_WSDL_URL);

    // this is the actual part that will call the webservice
    try {

        androidHttpTransport.debug = true;
        androidHttpTransport.call(soapActionUrl, envelope);
        String ss = androidHttpTransport.responseDump;

        // Get the SoapResult from the envelope body.

        Log.d(TAG, "request: " + androidHttpTransport.requestDump);
        Log.d(TAG, "response: "+    androidHttpTransport.responseDump);


        SoapObject result = (SoapObject) envelope.getResponse();

        Log.d("soap response", "" + result);            
    } catch (IOException e) {
        Log.e(TAG, "IOException", e);
    }