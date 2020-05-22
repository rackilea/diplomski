public class GetData extends AsyncTask<Void, Void, String>{

        String URL="http://10.0.2.2:8080/myproject/api/question/";

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO Auto-generated method stub

            //Put your http request code here.

            UserTemp user = new UserTemp();
            HttpClient httpclient = new DefaultHttpClient();  
            HttpGet request = new HttpGet(URL);  
            try {  
                //Parse xml
                HttpEntity r_entity = httpclient.execute(request).getEntity();
                String xmlString = EntityUtils.toString(r_entity, HTTP.UTF_8);
                Log.d("result:::", xmlString) ;
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = factory.newDocumentBuilder();
                InputSource inStream = new InputSource();
                inStream.setCharacterStream(new StringReader(xmlString));
                Document doc = db.parse(inStream);  
                NodeList nl = doc.getElementsByTagName("userTemp");
                for(int i = 0; i < nl.getLength(); i++) {
                    if (nl.item(i).hasChildNodes()) {

                        config.User_ID=nl.item(i).getChildNodes().item(0).getTextContent();
                        config.User_type_ID=nl.item(i).getChildNodes().item(1).getTextContent();
                        user.Password = nl.item(i).getChildNodes().item(2).getTextContent();

                    }
                    Log.d("soluongnode:", i+"");

                }
            } catch (ClientProtocolException e) {  
                Log.d("exception:", e.toString()) ;
            } catch (IOException e) {  
                Log.d("exception:", e.toString());
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                Log.d("exception:", e.toString());
            } catch (SAXException e) {
                // TODO Auto-generated catch block
                Log.d("exception:", e.toString());
            }  
            httpclient.getConnectionManager().shutdown();   

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
        }

    }