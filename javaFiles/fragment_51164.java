public class CaseConverter{
    public static void main(String args[]){
       int offset = 'a' - 'A';
       char temp = 'X';  // or any other uppercase alphabet
       System.out.println("uppercase: " + temp);
       temp = (char)((int)temp + offset);
       System.out.println("lowercase: " + temp);
    }
}