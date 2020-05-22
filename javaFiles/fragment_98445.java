import java.util.regex.Pattern;
import java.util.regex.Matcher;
class Module1{
  public static void main(String[] asd){
  String sourcestring = "Adidas, 45-46 Nike, 25 shoes, phone, keyboard, 1-2, 4-5, 7, 9, 12, 13, 32, 35, V, VI, IX";
  Pattern re = Pattern.compile("\\b(?:\\d+(?:-\\d+)?|(?=[MCDLXVI]+\\b)M{0,4}(?:CM|CD|D?C{0,3})(?:XC|XL|L?X{0,3})(?:IX|IV|V?I{0,3}))\\b",Pattern.CASE_INSENSITIVE );
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