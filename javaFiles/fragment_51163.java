public class CaseConverter{
    public static void main(String args[]){
       int offset = 'a' - 'A';
       int temp = 'X';  // or any other uppercase alphabet
       System.out.println("uppercase: " + (char)temp);
       temp = temp + offset;
       System.out.println("lowercase: " + (char)temp);
    }
}