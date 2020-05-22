URL url;
HttpURLConnection urlConnection = null;
try {
    url = new URL("http://www.domain.com/index.aspx?parameter1=X&parameter2=X"); //Use your url and add the GET parameters

    urlConnection = (HttpURLConnection) url.openConnection();

    urlConnection.setInstanceFollowRedirects(false); /* added line */

    InputStream in = urlConnection.getInputStream();

    InputStreamReader isw = new InputStreamReader(in);

    int data = isw.read();
    while (data != -1) {
        char current = (char) data;
        data = isw.read();
        System.out.print(current);
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (urlConnection != null) {
        urlConnection.disconnect();
    }    
}