import java.util.Scanner;
import java.lang.annotation.*;
import java.lang.reflect.Method;

public class Ch10LU2Ex4 {  
    @SuppressWarnings("deprecation")    
    public static void main(String[] args) {
        try {
            System.out.println("Enter a number between 100 and 999:");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            armstrong obj = new armstrong();
            obj.armStrong(x);
            Method method = obj.getClass().getMethod("armStrong", Integer.TYPE);
            Annotation[] annos = method.getAnnotations();
            for(int i = 0; i<annos.length; i++) {
                System.out.println(annos[i]);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}