import java.util.Scanner;

public class UseDelim {
    public static void main(String[] args) {
        String content = " <2008-10-07>text entered by user <Ted Parlor>"
        + "   <2008-11-26>  additional text entered by user <Ted Parlor>"
        + "   <2008-11-28><Parlor Ted>  ";
        Scanner sc = new Scanner(content).useDelimiter("\\s*[<>]\\s*");
        while (sc.hasNext()) {
            System.out.printf("[%s|%s|%s]%n",
                sc.next(), sc.next(), sc.next());

            // if there's a next entry, discard the empty string token
            if (sc.hasNext()) sc.next();
        }
    }
}