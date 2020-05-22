public class MySentenceCheckerCaller {
  public static void main(String[] args) {
     String str = "Lorem ipsum dolor sit amet your mom";
     SentenceChecker sc = new SentenceChecker();
     int wordCount = sc.countEnglishWords(str); // call method, assumes returns an int
     System.out.println("There are " + wordCount + " words in my string.");
   }
 }