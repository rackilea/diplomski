try {

    urlConn.connect();
} catch (IOException ex) {
    Logger.getLogger(Vetores_Facebook.class.getName()).log(Level.SEVERE, null, ex);
}

String message = URLEncoder.encode("get_object(\"me\", metadata=1)", "UTF-8");
try (OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream())) {
    writer.write(message);
    writer.close();

}