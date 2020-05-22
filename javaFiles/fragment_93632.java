private void post()
  throws MalformedURLException, IOException
{ URL url;
  URLConnection con;
  OutputStream oStream;
  String parametersAsString;
  byte[] parameterAsBytes;
  String aLine; // only if reading response

  parametersAsString = "msg=hi&to=memo";
  parameterAsBytes = parametersAsString.getBytes();
  // send parameters to server
  url = this.getCodeBase();
  url = new URL(url + "scriptfile.php");
  con = url.openConnection();
  con.setDoOutput(true);
// setDoInput(true); // only if reading response
  con.setDoInput(false);
  con.setRequestProperty("Content=length", String.valueOf(parameterAsBytes.length));
  oStream = con.getOutputStream();
  oStream.write(parameterAsBytes);
  oStream.flush();

 // read response from server & show the server response on the Java console or whatever ...
  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
  aLine = in.readLine();
  while (aLine != null)
  { System.out.println(line);
    aLine = in.readLine();
  }
  in.close(); 


  oStream.close();
}