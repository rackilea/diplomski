import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TxtToChar {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String string = "";
        char[] c;
        try {
            Scanner scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()){
                string += scanner.useDelimiter("\n").nextLine();

            }
             c = string.toCharArray();
             for(int i =0;i<c.length;i++){
                             if(c[i] !=' '){
                               System.out.println(c[i]);
                             }
             }
        }catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}