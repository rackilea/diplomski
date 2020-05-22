public class Example
{
    public static void main(String[] args) {
        String str ="abc123"; 
        for(int i = 0; i < str.length(); i++) {
            System.out.println(Character.isDigit(str.charAt(i)) ? "number" : "alphabet");
        }
    }
}