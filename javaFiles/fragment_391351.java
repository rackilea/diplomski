public class Test {

     public static void main(String[] args){
           String key = "hello";
           String keyWord = "";
           String message = "asdfghj";
           for (int i = 0; i < message.length();i++)
           {
               keyWord += key.charAt(i %key.length());             
           }
           System.out.println(keyWord);
}
}