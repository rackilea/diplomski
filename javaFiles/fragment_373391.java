import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        for(int i =0;i<Integer.parseInt(n);i++){
            String a= scanner.nextLine();

            for(int z =0; z < Integer.parseInt(a); z++){
                System.out.println(scanner.nextLine());
            }
        }
    }
}