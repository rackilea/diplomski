import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class Test {


        public static void main(String[] args) throws IOException {
            String line = "";
            String paragraph = "";

            System.out.println("Enter the text: ");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(isr);
                 do
                 {
                     line = bufferedReader.readLine();
                      paragraph = paragraph + line + " ";
                 }while(!line.equals("exit"));
              isr.close();
              bufferedReader.close();
              System.out.println(paragraph);
        }//method main ends here

    }