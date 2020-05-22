@Override
protected String doInBackground(String... params) {
    try{

    String str = "username=" + params[0] + "&password=" + params[1];
    String data = URLEncoder.encode("str", "UTF-8") + "=" +
            URLEncoder.encode(str, "UTF-8");
    strUrl ="http://10.0.2.2/android/login.php?"+data+"";
    Log.d("STR", data);


    URL url = new URL (strUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("POST");
    con.connect();