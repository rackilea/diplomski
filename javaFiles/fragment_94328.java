private String getStringFromFile(String matching, File inFile) throws IOException {
   BufferedReader br = new BufferedReader(new FileReader(inFile));
   String line;
   while ((line = br.readLine()) != null) {
       if (line.contains(matching)) {
           br.close();
           return line;
       }
   }
   br.close();
   return "";
}