SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
URL url = new URL("https://gridserver:3049/cgi-bin/ls.py");
HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
conn.setSSLSocketFactory(sslsocketfactory);
InputStream inputstream = conn.getInputStream();
InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

String string = null;
while ((string = bufferedreader.readLine()) != null) {
    System.out.println("Received " + string);
}