import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LendoRockyYou {

    public static void main(String[] args) {
        ler();
    }

    public static void ler() {
    int total = 0;
        try {    
            BufferedReader in = new BufferedReader(new FileReader("C:\\rockyou.txt"));
            String line;
            while ((line = in.readLine()) != null) {
        total = total + tratar(line);
                System.out.println(total);
            }
            System.out.println(total);
            in.close();
    }catch(Exception e){
            e.printStackTrace();
            System.out.println("Arquivo .txt não encontrado");
    }
    }

    public static int tratar(String text) throws IOException {
        int total = 0;
        try{
            total = total + Integer.parseInt(text);
        }catch(NumberFormatException e){
            total = total + 0;
        }
        return total;
    }
}