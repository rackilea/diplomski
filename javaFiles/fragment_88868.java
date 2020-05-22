public static boolean isInternetConnected(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context
            .getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo ni = cm.getActiveNetworkInfo();

    if (ni == null)
        return false;
    else {
        if (ni.isConnected())
            if (isOnline(context))
                return true;
            else
                return false;
        return false;
    }
}


public static boolean isOnline(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context
            .getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnected()) {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection urlc = (HttpURLConnection) url
                    .openConnection();
            urlc.setConnectTimeout(2000);
            urlc.connect();
            if (urlc.getResponseCode() == 200) {
                return new Boolean(true);
            }
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    return false;
}