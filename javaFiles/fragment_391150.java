public class FileWrite {
       public static void write(String message) { 
                PrintWriter out = null;
              try {
                  out = new PrintWriter(new FileWriter("output.txt"), true);
              } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
                out.write(message);
                out.close();
        }

       public static void main(String[] args){
           String lineFromInput;
           try {
                BufferedReader in = new BufferedReader(
                                            new InputStreamReader(System.in));
                lineFromInput = in.readLine();
                FileWrite.write(lineFromInput);
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
           }
       }
     }