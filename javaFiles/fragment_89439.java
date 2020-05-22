public List<String> getMyWords() 
{
    List<String> words = new ArrayList<String>();
    try {
        InputStream inputStream = getResources().openRawResource(R.raw.chardb);
        BufferedReader input =  new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        try {
            String line = null;
            while (( line = input.readLine()) != null){
                words.add(line);
            }
          }
        finally {
        input.close();
        }
    }
    catch (IOException e){
      e.printStackTrace();
    }

    return words;
}