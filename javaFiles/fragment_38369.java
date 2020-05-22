import org.apache.commons.lang3.StringUtils;

public class Test {
   public static void main(String[] args) {

      String input ="C:\\Users\\user\\Desktop\\folder";

      String[] output = StringUtils.split(input, "\\");

      System.out.println(output[output.length-1]);
    }
}