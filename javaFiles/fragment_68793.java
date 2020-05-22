private class ObtinereInformatii extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            //http post
            try {
                HttpClient httpclient = new DefaultHttpClient();


                HttpPost httppost = new HttpPost("http://asociatia-online.esy.es/rezumat.php");
                nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("luna_rezumat",spinner_luna.getSelectedItem().toString().trim()));
                nameValuePairs.add(new BasicNameValuePair("an_rezumat",spinner_an.getSelectedItem().toString().trim()));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection" + e.toString());
            }
//convert response to string
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                sb = new StringBuilder();
                sb.append(reader.readLine() + "\n");

                String line = "0";
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();
                Log.e("-------",result);
            } catch (Exception e) {
                Log.e("log_tag", "Error converting result " + e.toString());
            }

            return result;
        }

        protected void onPostExecute(String result){

                try{
                jArray = new JSONArray(result);

                readJson(jArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    private void readJson(JSONArray ja_data) throws JSONException {
        if (ja_data!=null)
        {
            for (int i = 0; i<ja_data.length(); i++)
            {
                JSONObject jo = ja_data.getJSONObject(i);
                if (jo.has("data_rezumat"))
                {
                    if (jo.getString("data_rezumat")!=null)
                    {
                        z_data_rezumat= jo.getString("data_rezumat");
                    }
                }
            }
        }
    }