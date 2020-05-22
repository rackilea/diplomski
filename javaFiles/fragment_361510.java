import java.io.IOException;

public class run_java_program {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("java -cp C:\\Users\\96171\\eclipse-workspace\\IR_Project\\src test");
            java.util.Scanner s = new java.util.Scanner(process.getInputStream());
            System.out.println(s.nextLine());
        } catch (IOException e) {  
            e.printStackTrace();  
       }  
    }
}