public class Intern{
    public static void main(String... args){
        String str1="TestStr";
        String str2="TestStr";
        System.out.println("1. "+(str1==str2));
        String str3=str1.intern();
        System.out.println("2. "+(str1==str3));
        String str4=new String("TestStr");
        System.out.println("3. "+(str1==str4));
        String str5=str4.intern();
        System.out.println("4. "+(str4==str5));
        System.out.println("5. "+(str1==str5));
    }
}