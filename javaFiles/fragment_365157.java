public static void main(String[] args) {
       int a;
       double b;
       String c;

       Scanner sc=new Scanner(System.in);
       a=sc.nextInt();
       b=sc.nextDouble();

       sc.nextLine(); // This line skips the part, after the double value.

       c=sc.nextLine();
       System.out.println(a+4);
       System.out.println(b+4.0);
       System.out.println("Hackerrank"+" "+c);


    }