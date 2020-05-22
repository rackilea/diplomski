try {
    InputStream in;
    String url = "jar:file:/usr/share/zenta/plugins/org.rulez.magwas.zenta.help_2.4.0.201401091630.jar!/hints/viewpoint_total.html"
    JarURLConnection con = (JarURLConnection)url.openConnection();
    in = con.getInputStream();
    // read the stream
  } catch (MalformedURLException ex) {
    System.err.println("Malformed URL: "+url);
  } catch (IOException ex) {
    System.err.println("IO error");
  } finally {
    in.close();
  }