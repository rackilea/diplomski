int getWords() throws IOException {
  int count = 0;
  BufferedReader BF = new BufferedReader(new FileReader(f));
  String line;
  try {
    while ((line = BF.readLine()) != null) {
      StringTokenizer words = new StringTokenizer(line); 
      while(words.hasMoreTokens()) { 
        count++;
        words.nextToken(); 
      }    
    }
    return count;
  } catch(FileNotFoundException e)  {
  } finally {
    BF.close();
  }
  // Either rethrow the exception or return an error code like -1.
}