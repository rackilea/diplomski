import java.io.FileOutputStream;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringEscapeUtils;

String[] myStringPool = {"Steve O#8217Conord and Mirco Savas","Rusell O&#146Connell"};
PrintWriter pw = new PrintWriter("utf-8.txt", "UTF-8");
for(String string : myStringPool) {
    pw.println(StringEscapeUtils.unescapeXml(string.replaceAll("&?#(\\d+);?", "&#$1;")));
}
pw.close();