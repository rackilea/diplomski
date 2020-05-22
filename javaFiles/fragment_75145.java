String jsUrl = "https://www.hellobank.fr/rsc/contrib/script/hb2/js/app/pages/video-bienvenue.js";
    URL obj = new URL(jsUrl);
    HttpURLConnection cnt = (HttpURLConnection) obj.openConnection();
    cnt.setRequestMethod("GET");
    cnt.setRequestProperty("User-Agent", "Mozilla/5.0");
    InputStream stream = cnt.getInputStream();
    if ("gzip".equalsIgnoreCase(cnt.getHeaderField("Content-Encoding"))) {
          stream = new GZIPInputStream(stream);
    }
    BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    String inputLine;
    StringBuffer response = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();
    System.out.println(response.toString()); //here is the content of the file you need