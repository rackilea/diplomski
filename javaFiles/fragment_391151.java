public class FileWrite {
   public static void write(String message) { 
            PrintWriter out = null;
          try {
              out = new PrintWriter(new FileWriter("output.txt", true), true);
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
            out.write(message);
            out.close();
    }

   public static void main(String[] args){
       String lineFromInput = "";
       try {
            System.out.println("Provide the inputs in any number of lines");
            System.out.println("Type \"exit\" in new line when done");
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(System.in));
            while(!"exit".equals(lineFromInput)){
               lineFromInput = in.readLine();
               FileWrite.write(lineFromInput+System.lineSeparator());
            }
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
       }
   }
 }