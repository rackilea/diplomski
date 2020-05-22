import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {
public static String TEXT_FILE_LOCATION="input.txt";
public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new File(TEXT_FILE_LOCATION));
    String stringToSearch=in.nextLine();
    StringBuffer buffer=new StringBuffer();
    for(;in.hasNext();){
        buffer.append(in.next());
    }
    Pattern pattern = Pattern.compile(stringToSearch);
    Matcher matcher = pattern.matcher(buffer.toString());
    int from = 0;
    int count = 0;
    while(matcher.find(from)) {
        count++;
        from = matcher.start() + 1;
    }
    System.out.println("Number of matches : "+count);
}
}