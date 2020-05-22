public class FileReading extends ConsoleProgram {   

   public void readFile(){
     BufferedReader rd = null;
     try {
         rd = new BufferedReader(new FileReader("file.txt"));
         while (true) {          
            String line = rd.readLine();
            if (line == null) {
                break;
            }
            println(line);
         }
     }catch (IOException ex) {
         throw new ErrorException(ex);
     }finally{
        try{
         rd.close();
        }catch (IOException ex) {
         throw new ErrorException(ex);
        }
     }
   }
}