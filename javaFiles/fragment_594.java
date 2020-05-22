public static void main(String[] args)
{
    long x = 99999;
    long y = 99999;
    long answer = ((x+y-1)*(x+y-2))/2 + x;
    String s = Long.toString(answer);
    System.out.println(s);
}