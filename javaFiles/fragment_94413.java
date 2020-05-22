public static String getStringFromUrl(String url) throws UnsupportedEncodingException{
    BufferedReader br = new BufferedReader(new InputStreamReader(getInputStreamFromUrl(url)));

    StringBuilder sb = new StringBuilder();
    try{
    String line = null;
    while((line = reader.readLine()) != null)
    {
        sb.append(line);
    }    
    }catch (IOException e){
     e.printStackTrace();
    }
    getInputStreamFromUrl(url).close();
    return sb.toString();
}