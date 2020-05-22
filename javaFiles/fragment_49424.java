import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;    

void checkInput() {

    Scanner s = new Scanner(System.in);
    Pattern p = Pattern.compile("^[1-5]$");  // only one digit between 1-5
    Matcher m;
    boolean match = false;

    while (!match){
        System.out.print("Enter a number between 1 and 5: ");
        m = p.matcher(s.next());
        if(m.find()){
            match = true;
            int input = m.group(0);
            // switch...
        }
    }
}