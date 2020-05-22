public static void main(String[] args) throws java.lang.Exception {
        System.out.println("setcaculatorinput");
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        System.out.println("setvalueA");
        int a = sc.nextInt();
        System.out.println("setvalueB");
        int b = sc.nextInt();
        int c, d, e, f;

        c = (a + b);
        d = (a - b);
        e = (a * b);
        f = (a / b);

        if ("+".equals(z))
            ;
        if ("-".equals(z))
            ;
        if ("*".equals(z))
            ;
        if ("/".equals(z))
            ;

        { // init block
            System.out.println(c);
            System.out.println(d);
            System.out.println(e);
            System.out.println(f);
        }
        System.exit(0);
    }