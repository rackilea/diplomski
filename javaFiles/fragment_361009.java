public class Test {
     public static void main(String[] args) {
         String s = "12345678912345678912345678";
         String formatted = s.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
         System.out.println(formatted); // 12,345,678,912,345,678,912,345,678
     }
}