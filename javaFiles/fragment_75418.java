try
{
HttpClient httpclient = new DefaultHttpClient();
         HttpPost httppost = new HttpPost("servlet path here");
         HttpResponse response = httpclient.execute(httppost);
         HttpEntity entity = response.getEntity();
          is = entity.getContent();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        is.close();
        json = sb.toString();

    } catch (Exception e) {
    Toast.makeText(getBaseContext(), "Buffer Error"+"Error converting result"+e.toString(), Toast.LENGTH_LONG).show();
    }

    try {
        jObj = new JSONObject(json);
        contacts = jObj.getJSONArray("get");
        for(int i = 0; i < contacts.length(); i++){
        JSONObject c = contacts.getJSONObject(i);
            vcode = c.getString("vcode");
            vname = c.getString("vname");
            divsec = c.getString("divsec");
        }
        ac1.setText(""+vname);
        ac2.setText(""+vcode);
        ac3.setText(""+divsec);

    } catch (JSONException e) {
        Toast.makeText(getBaseContext(), "Error"+e.toString(), Toast.LENGTH_LONG).show();
    }