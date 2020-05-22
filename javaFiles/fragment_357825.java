import  java.util.Arrays;
import  java.util.ArrayList;
import  java.util.regex.Matcher;
import  java.util.regex.Pattern;

/**
   <P>{@code java DoubleInParenStringsToArrays}</P>
 **/
public class DoubleInParenStringsToArrays  {
   public static final void main(String[] ignored)  {
      String input = "(1.0,2.0) (2,7.6) (2.1,3.0)";
      String[] inputs = input.split(" ");

      //"": Dummy string, to reuse matcher
      Matcher mtchrGetNums = Pattern.compile("\\b([\\d.]+)\\b").matcher("");
      for(String s : inputs)  {

         ArrayList<Double> doubleList = new ArrayList<Double>();
         mtchrGetNums.reset(s);
         while(mtchrGetNums.find())  {
            //TODO: Crash if it's not a number!
            doubleList.add(Double.parseDouble(mtchrGetNums.group(0)));
         }

         Double[] doubles = doubleList.toArray(new Double[doubleList.size()]);
         System.out.println(Arrays.toString(doubles));
      }
   }
}