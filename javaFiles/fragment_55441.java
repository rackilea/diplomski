public static void main(String[] args) 
{
  if (args == null || args.length < 2) {
    System.out.println("Not enough arguments.");
    System.exit(1);
  }
  int val = Integer.valueOf(args[args.length - 1]);
  for (int i = 0; i < args.length - 1; i++) {
    if (i != 0) {
      System.out.print(' ');
    }
    System.out.print(encode(args[i], val));
  }
  System.out.println();
}