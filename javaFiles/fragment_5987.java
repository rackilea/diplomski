ServletInputStream inputStream = request.getInputStream();
    GZIPInputStream gis = new GZIPInputStream(inputStream);
    BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
    StringBuilder sb = new StringBuilder();
    String line;
    while((line = br.readLine()) != null) {
        sb.append(line);
    }

    System.out.println(sb.toString());