public void getXML(){       
    try {
       URL url = new URL(urlLink);
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       conn.setRequestMethod("POST");
       conn.setReadTimeout(15000);
       conn.setConnectTimeout(15000);
       conn.setDoInput(true);
       conn.connect();
       is = conn.getInputStream();
       Log.d("InputStreamContents", is.toString());
       parseXML(is);
       is.close();
   }catch(Exception e){
       e.printStackTrace();
   }
}