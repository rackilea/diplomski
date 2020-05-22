import java.util.*;
public class Namek {
        static int myMethod(int radius) {
            return ((radius * radius) * (22/7));
        }
        public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter Radius");
            int radius = Integer.valueOf(keyboard.nextLine());
            int area = myMethod(radius);
            System.out.println(area);
        }
}