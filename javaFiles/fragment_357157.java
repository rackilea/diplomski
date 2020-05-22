private String wifi_ip() 
    {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet("http://wiki.iti-lab.org/ip.php");
            HttpResponse response;

            response = httpclient.execute(httpget);

            // Log.i("externalip",response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                long len = entity.getContentLength();
                if (len != -1 && len < 1024) {
                    String str = EntityUtils.toString(entity);
                    // Log.i("externalip",str);
                    // ip.setText(str);
                    ip1 = str;
                }
            }
        } catch (Exception e) {
            // ip.setText("Error");
        }
        return ip1;
    }