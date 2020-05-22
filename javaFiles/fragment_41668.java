try {
   test = new URL("http://localhost/out.php");
   URLConnection urlConn = test.openConnection();
   in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
} catch (MalformedURLException e) {
    inputLine = "test_synntax";
} catch (IOException e) {
    inputLine = "test_synntax";
}