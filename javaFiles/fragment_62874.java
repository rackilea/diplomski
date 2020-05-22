public class A<T>{
    public static Integer member = 0;

    public static void main(String[] args)
    {
      A<Integer> integer = new A<Integer>();
      A<String> string = new A<String>();

      integer.member++;
      System.out.println(string.member);
    }
}