import com.sun.org.apache.xml.internal.utils.StringComparable;
import com.sun.xml.internal.ws.util.StringUtils;

public class matchSubstring {

    public static void main (String[]args){

    String originalString = "<b>ProLiantDL380CltrG2</b> HWSupp";
    String subString = "ProLia";

    if (originalString.contains(subString)) {
    System.out.println("substring matched true");
    System.out.println("before : " + originalString);
    //Need to remove the <b> & </b> from the originalString
    originalString= originalString.replace("<b>", ""); 
    originalString=originalString.replace("</b>", "");

    StringBuilder strb=new StringBuilder(originalString).insert(subString.length(),"</b>");
    strb.insert(0,"<b>");

    System.out.println("after : " + strb);
}
}}