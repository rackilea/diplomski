import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.util.List;

class Program {
public static void main (String[] args) throws java.lang.Exception  {

String subject = "exp_0-a_1-b_2-c_3-d_4-exp_5";
Pattern regex = Pattern.compile("a_\\d-b_\\d|c_\\d-d_\\d|(-)");
Matcher m = regex.matcher(subject);
StringBuffer b= new StringBuffer();
while (m.find()) {
    if(m.group(1) != null) m.appendReplacement(b, "SplitHere");
    else m.appendReplacement(b, m.group(0));
}
m.appendTail(b);
String replaced = b.toString();
String[] splits = replaced.split("SplitHere");
for (String split : splits) System.out.println(split);
} // end main
} // end Program