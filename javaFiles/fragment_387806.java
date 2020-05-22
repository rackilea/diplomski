Override
    protected Integer doInBackground(String... params) {
        // TODO Auto-generated method stub
         try 
          {
             SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                 PropertyInfo pi1 = new PropertyInfo();
                 pi1.setName("arg0");
                 pi1.setValue("admin");
                 pi1.setType(String.class);
                 request.addProperty(pi1);

                 PropertyInfo pi2 = new PropertyInfo();
                 pi2.setName("arg1");
                 pi2.setValue("admin");
                 pi2.setType(String.class);
                 request.addProperty(pi2);

                 SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                 envelope.setOutputSoapObject(request);
                 System.setProperty("http.keepAlive", "false");
HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                 androidHttpTransport.debug=true;
                 androidHttpTransport.call(getSoapAction(METHOD_NAME), envelope);
                 SoapObject result = (SoapObject) envelope.bodyIn;
                 //get response from web server
                 String d =result.getProperty("return").toString();
                 // Logging the raw request and response (for debugging purposes)
                 Log.d(TAG, "HTTP REQUEST:\n" + androidHttpTransport.requestDump);
                 Log.d(TAG, "HTTP RESPONSE:\n" + androidHttpTransport.responseDump);
                 Log.i(TAG,"response from service:"+d);
                 if(d.equals("true"))
                 {
                    //The result will be here, use it wisely :)
                    return 1;
                 }

                 else
                    return 0;
                 } catch (Exception e) {
                 Log.e(TAG,"doInBackground failed"+e);
                 e.printStackTrace();
                 return 0;

              }

        }