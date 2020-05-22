import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vec
{
    public static void main(String[] args) {
        List <Colors> l = new ArrayList<>();
        boolean flag = true;

        Scanner kb = new Scanner (System.in);

        while (flag) {
            System.out.println("Type in name of color");

            Colors col = new Colors ();
            col.name = kb.next();
            l.add(col);

            for (int j = 0; j<l.size();j++) {
                Object g = (Object)l.get(j);
                System.out.println("Name of color: "+g);
            }
        }
    }
}