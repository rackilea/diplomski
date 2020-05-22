import java.util.regex.Pattern;
import java.util.regex.Matcher;
class Module1{
  public static void main(String[] asd){
  String sourcestring = "source string to match with pattern";
  Pattern re = Pattern.compile("^(?=(?:[-+*/^]?[-+]?\\d+(?:[.]\\d+)?)*$)([-+]?[0-9.]+$|[-+]?[0-9.]+(?:[-+*/^][-+]?[0-9.]+)*(?=[-+*/^]))(?:([-+*/^])([-+]?[0-9.]+))?$",Pattern.CASE_INSENSITIVE);
  Matcher m = re.matcher(sourcestring);
  int mIdx = 0;
    while (m.find()){
      for( int groupIdx = 0; groupIdx < m.groupCount()+1; groupIdx++ ){
        System.out.println( "[" + mIdx + "][" + groupIdx + "] = " + m.group(groupIdx));
      }
      mIdx++;
    }
  }
}