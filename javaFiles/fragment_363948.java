public static void main(String[] args) {

     BufferedReader br = null;
      try {
           br = new BufferedReader(new FileReader(new File(FILE)));

           //read the 2rd part of the file till Header2 line
           List<String> lines1 = readLines(br, 
                              "============= Header 2 ===================");

           //read the 2rd part of the file till Header3 line
           List<String> lines2 = readLines(br, 
                              "============= Header 3 ===================");

            //read the 3rd part of the file till end        
            List<String> lines3 = readLines(br, "");

        } catch (IOException e) {
             e.printStackTrace();
        } finally {
            //close BufferedReader
        }
   }

   private static List<String> readLines(BufferedReader br, String nextHeader) 
                                                  throws IOException {
                 String sCurrentLine;
                 List<String> lines = new ArrayList<>();
                 while ((sCurrentLine = br.readLine()) != null) {
                     if("".equals(nextHeader) || 
                         (nextHeader != null &&      
                       nextHeader.equals(sCurrentLine))) {
                         lines.add(sCurrentLine);
                     }
                 }
                 return lines;
      }