import java.util.regex.*;


public class Main{
    public static void main(String[] args) {
        String[] myArray = new String[] {"0.10 AND 23","12 AND (15 OR 0.2)","12 OR 190","12 AND AND 12","12 A 233"};
        String regex = "^([\\d\\s().]|\\bAND\\b|\\bOR\\b)+$";

        for (int i = 0; i < myArray.length; i++)
        System.out.println(myArray[i].matches(regex));

    }
}