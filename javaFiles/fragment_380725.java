SoapSerializationEnvelope env = new SoapSerializationEnvelope(SoapEnvelope.VER11);
androidHttpTransport = new HttpTransportSE(URL);
androidHttpTransport.debug=true;
(new MarshalHashtable()).register(env);
// filter
Hashtable <String, String> filter=new Hashtable<String, String>();
filter.put("customer_id", "1");
request.addProperty("filter", filter);