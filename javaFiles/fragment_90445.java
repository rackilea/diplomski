/* Get a SAXParser from the SAXPArserFactory. */
                     SAXParserFactory spf = SAXParserFactory.newInstance();
                     SAXParser sp = spf.newSAXParser();

                     /* Get the XMLReader of the SAXParser we created. */
                     XMLReader xr = sp.getXMLReader();

                     /*
                      * Create a new ContentHandler and apply it to the
                      * XML-Reader
                      */
                     GoogleWeatherHandler gwh = new GoogleWeatherHandler();
                     xr.setContentHandler(gwh);

                     /* Use HTTPClient to deal with the URL */ 
                     HttpClient httpclient = new DefaultHttpClient(); 
                     HttpGet httpget = new HttpGet(queryString.replace(" ", "%20")); 
                     Log.d(DEBUG_TAG, "executing request " + httpget.getURI()); 
                     // create a response handler 
                     ResponseHandler<String> responseHandler = new BasicResponseHandler();
                     Log.i("Respond Handler","Step 1");
                     String responseBody = httpclient.execute(httpget, responseHandler); 
                      Log.d(DEBUG_TAG, "response from httpclient:\n "+responseBody); 

                     ByteArrayInputStream is = new ByteArrayInputStream(responseBody.getBytes()); 
                     xr.parse(new InputSource(is)); 
                     Log.d(DEBUG_TAG, "parse complete"); 
                     // parse complete