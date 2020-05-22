@Test
public void testLocation() throws Exception {
    final String link = "http://bit.ly/4Agih5";

    final URL url = new URL(link);
    final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.setInstanceFollowRedirects(false);

    final String location = urlConnection.getHeaderField("location");
    assertEquals("http://stackoverflow.com/", location);
    assertEquals(link, urlConnection.getURL().toString());
}