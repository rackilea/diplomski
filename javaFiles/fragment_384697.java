URL url = new URL("http://www.example.com/");
  Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8080)); // or whatever your proxy is
  HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);

  uc.connect();

    String line = null;
    StringBuffer tmp = new StringBuffer();
    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
    while ((line = in.readLine()) != null) {
      tmp.append(line);
    }

    Document doc = Jsoup.parse(String.valueOf(tmp));