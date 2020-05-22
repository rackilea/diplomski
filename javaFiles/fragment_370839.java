If You Want to call Rest Webservice than Here Is the Code:



class LongOperation extends AsyncTask<String, String, String>{

            @Override
            //  http://stackoverflow.com/questions/3505930/make-an-http-request-with-android
            protected String doInBackground(String... uri) {
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response;
                String responseString = null;
                try {
                    response = httpclient.execute(new HttpGet(uri[0]));
                    StatusLine statusLine = response.getStatusLine();
                    if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        response.getEntity().writeTo(out);
                        out.close();
                        responseString = out.toString();
                    } else{
                        //Closes the connection.
                        response.getEntity().getContent().close();
                        throw new IOException(statusLine.getReasonPhrase());
                    }
                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return responseString;
            }




If You Want to call WCF/asmx Webservice than Here Is the Code:
Here You have to use KSOAP2 library

private final String NAMESPACE = "http://tempuri.org/";
private final String URL = "[http://10.0.2.2:8085/Service1.svc][1]";
//Use Service1.asmx for asmx service
private final String SOAP_ACTION = "http://tempuri.org/GetData";
private final String METHOD_NAME = "GetData";


                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

                try {

                    androidHttpTransport.call(SOAP_ACTION, envelope);
                    SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
                    Log.i("myApp_Responce...", response.toString());

                    TextView tv= (TextView)findViewById(R.id.textView1);
                    tv.setText(response.toString());
                      } catch (Exception e)
                      {
                          e.printStackTrace();
                       }