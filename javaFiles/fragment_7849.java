public static String getResponse(HttpsURLConnection conn) {
    Log.i(TAG, "in getResponse");
    InputStream is = null;
    try {
        if(conn.getResponseCode()>=400){
            is = conn.getErrorStream();
        }
        else{
            is=conn.getInputStream();
        }
        ...read stream...
}