import java.io.*;
import java.util.*;

public class Translator {

  private static Scanner scan;

  public static void main(String[] args) {

    HashMap <String, String> XanthiumLang = new HashMap <String, String>();
    XanthiumLang.put("hello", "fohran");
    XanthiumLang.put("the", "krif");
    XanthiumLang.put("of", "ney");
    XanthiumLang.put("to", "dov");
    XanthiumLang.put("and", "ahrk");

    Scanner scan = new Scanner(System.in);
    String sentence = scan.nextLine();
    String[] result = sentence.split(" ");
      for(int i = 0; i < result.length; i++){
         if(XanthiumLang.containsKey(result[i])){
           result[i] = XanthiumLang.get(result[i]);
         }
         System.out.print(result[i]);
       }
     }
   }