if(responseCode == HttpURLConnection.HTTP_OK)
{ /* Note the brace to start a block! */
  InputStream inp = new BufferedInputStream(httpconnection.getInputStream());
  /* Now use the stream within the block. */
  ...
}