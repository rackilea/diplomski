public String readIt(InputStream stream) throws IOException, UnsupportedEncodingException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
    String line;
    while ((line = br.readLine()) != null){
      sb.append(line);
    }
    br.close();
    return sb.toString();
}