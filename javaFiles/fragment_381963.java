private BufferReader createBufferedReader(String fileName) {
   BufferReader br = null;
   try {
     br = new BufferReader(new FileReader(fileName));
     return br;
   } catch(FileNotFoundException e) {
       System.err.println("Not found file" + fileName);
   }
   return null;
}