public static void main (String[] args) throws java.lang.Exception
{
    String regex = "^[\u0400-\u04FFa-zA-Z ]+(,[\u0400-\u04FFa-zA-Z ]+)*$";

    System.out.println("abc,xyz,pqr".matches(regex)); // true
    System.out.println("text1,text2,".matches(regex)); // false
    System.out.println("ЕЖЗ,ИЙК".matches(regex)); // true
}