public static void main(String[] args) {
    List <Integer> e = new ArrayList<> ();
    List <Integer> o = new ArrayList<> ();
    List <Integer> n = new ArrayList<> ();
    Scanner s = new Scanner(System.in);

    for (int i = 0; i < 10; i++)
    {
        System.out.println("Enter the number");
        int a = s.nextInt ();

        if (a > 0)
        {
            if (a % 2 == 0) e.add (a);
            else o.add (a);
        }
        else n.add (a);
    }

    System.out.println("Even numbers: " + e);
    System.out.println("Odd numbers: " + o);
    System.out.println("Negative numbers: " + n);
}