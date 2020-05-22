{
...
    List<NameValuePair> params = new ArrayList<>();
     params.add(new BasicNameValuePair("string",longString));
     makeHttpRequest(url,"POST", params);
...
}

    public void makeHttpRequest(String url, String method, List<NameValuePair> params) {


        try {
            if (method == "POST"){
                DefaultHttpClient httpClient= new DefaultHttpClient();
                HttpPost httpPost =new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(params));

                HttpResponse httpResponse=httpClient.execute(httpPost);
                HttpEntity httpEntity=httpResponse.getEntity();
                is=httpEntity.getContent();

            }else if (method == "GET"){

                DefaultHttpClient httpClient=new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params,"utf-8");
                if (!paramString.matches(""))
                {
                url +="?"+paramString;
                }
                HttpGet httpGet = new HttpGet(url);
                lru =url;

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity=httpResponse.getEntity();
                is=httpEntity.getContent();

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}