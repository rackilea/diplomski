public class QuestionFactory {

 static final HashMap<String, String > map =  new HashMap<String,String>();

 static {
    this.getClassLoader().loadClass("TrueFalseQuestion");
    this.getClassLoader().loadClass("AnotherTypeOfQuestion"); // etc.
 }

 public static void registerType(String questionName, String ques ) {
     map.put(questionName, ques);
     }
 }