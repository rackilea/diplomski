static Consumer<String> C;
static String S;
public static void main(String[] args)
{
  Runnable r;
  r = () -> C = s -> S = s;
}