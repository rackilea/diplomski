String url=getUrl();
    JSONObject jsonObject = new JSONObject();
    StringBuilder stringBuilder=new StringBuilder();
    try 
    {
        HttpGet httpGet = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        InputStream stream = entity.getContent();
        int b;
        while ((b = stream.read()) != -1) {
            stringBuilder.append((char) b);
        }

        jsonObject = new JSONObject(stringBuilder.toString());

    } catch (JSONException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
    } catch (IOException e) {    }