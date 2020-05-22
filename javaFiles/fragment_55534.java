public class Test {
    public static void main(String[] args) {
         final var variable = new Object() {
               final int x = 10;
         };    
         System.out.println(variable.getClass());
    }
}