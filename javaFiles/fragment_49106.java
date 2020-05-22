try {
response = client.execute(request);

    Log.d("Response of GET request", response.toString());
} catch (ClientProtocolException e) {
    // TODO Auto-generated catch block
        e.printStackTrace();
} catch (IOException e) {
      // TODO Auto-generated catch block
     e.printStackTrace();
}