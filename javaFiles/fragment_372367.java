public List<String> readTokens(InputStream is) throws IOException{
    Reader reader = new InputStreamReader(is);
    List<String> tokens = new ArrayList<String>();
    BufferedReader bufferedReader = new BufferedReader(reader);
    String line = null;
    while((line = bufferedReader.readLine()) != null){
        String[] lineTokens = StringUtils.split(line, " "); 
        for(int i = 0 ; i < lineTokens.length ; i++){
            tokens.add(lineTokens[i]);
        }
    }
    return tokens;
}