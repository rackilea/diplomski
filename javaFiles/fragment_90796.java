URL url = new URL("http://structureddata.wikispaces.com/Test");

  URLConnection urlConnection = url.openConnection();
  Map<String, List<String>> headers = urlConnection.getHeaderFields();
  Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
  for (Map.Entry<String, List<String>> entry : entrySet) {
    String headerName = entry.getKey();
    System.out.println("Header Name:" + headerName);
    List<String> headerValues = entry.getValue();
    for (String value : headerValues) {
      System.out.print("Header value:" + value);
    }
    System.out.println();
    System.out.println();
  }