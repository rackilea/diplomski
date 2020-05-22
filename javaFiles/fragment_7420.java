public static void main(String[] args) {
        System.out.println("setcaculatorinput");
        Scanner sc = new Scanner(System.in);
        int result = 0;

        System.out.println("setvalueA=");
        int a = sc.nextInt();

        System.out.println("setOperator=");
        String op = sc.next();

        System.out.println("setvalueB=");
        int b = sc.nextInt();

        if ("+".equals(op))
            result = a + b;
        else if ("-".equals(op))
            result = a - b;
        else if ("*".equals(op))
            result = a * b;
        else if ("/".equals(op))
            result = a / b;

        System.out.println("The result is=" + result);
        System.exit(0);
    }