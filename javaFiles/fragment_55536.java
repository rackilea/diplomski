public class AClass { 
    public static void main(String[] args) {
        final var variable = new AClass() { 
             final int x = 10; 
        }; 
        System.out.println(variable.x); 
    } 
}