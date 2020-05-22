private Node dictionaryTree;   // this is the tree within your dictionary class

   public Dictionary(String filePath) throws IOException{
         BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"));
         this.dictionaryTree = readFile(br);
         br.close();
   }