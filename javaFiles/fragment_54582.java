private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
@Override
protected Double doInBackground(String... params) {
    postData(params[0]);
    return null;
}

protected void onPostExecute(Double result){} 

protected void onProgressUpdate(Integer... progress){
pb.setProgress(progress[0]);
}
}

public void postData(String valueIWantToSend) {
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://somewebsite.com/receiver.php");

    try {
      List nameValuePairs = new ArrayList();
      nameValuePairs.add(new BasicNameValuePair("myHttpData", valueIwantToSend));
      httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
      HttpResponse response = httpclient.execute(httppost);
    } catch (Exception e) {}
}