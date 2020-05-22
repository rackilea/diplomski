import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Allrecipes {
    public static void main(String[] args) throws Exception {

    System.out.println("Colby Mehmen");

    // http://allrecipes.com/Recipe/Cardamom-Maple-Salmon/Detail.aspx?soid=carousel_0_rotd&prop24=rotd

    String str1 = "";
    str1 = compare();

    if (str1.contains("http://allrecipes.com")) {

        URL oracle = new URL(str1);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                oracle.openStream()));

        String html = null;
        String line;
        while ((line = in.readLine()) != null)
            html += line;

        in.close();

        String page = html;

        int start = page.indexOf("<title>");
        int end = page.indexOf("</title>");

        String title = page.substring(start+7, end);
        System.out.println(title);

    }// end program

}

public static String compare() {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter recipe URL: ");
    String str1 = input.next();
    String str2 = "allrecipes.com";
    String str3 = "http://";

    boolean b = str1.contains(str2);

    if (b == true) {
        boolean c = str1.contains(str3 + str2);

        if (c == false) {
            str1 = str3 + str1;

        }
    }// endifif

    boolean d = str1 != str3 + str2;
    if (d == false) {

        System.out.println("ERROR");
    }

    /* cOUT */System.out.println(str1);

    return str1;
}// end compare

}