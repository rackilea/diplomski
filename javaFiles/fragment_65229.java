public static void main(String args[]) {
    Scanner sc = null;
    try {
        sc = new Scanner(System.in);
        System.out.print("Enter number till u want Tribonacci series: ");
        int n = sc.nextInt();

        int a = 0, b = 0, c = 1;
        int d = a + b + c;
        List<Integer> triboList = new ArrayList<Integer>();
        if(n <= 0) {
            System.out.println("Invalid number. Number must be greater than zero");
            return;
        }
        System.out.println("\nTribonacci Series: ");
        if (n == 1) {
            System.out.print(a);
            triboList.add(a);
        } else if (n == 2) {
            System.out.print(a + "\t" + b);
            triboList.add(a);
            triboList.add(b);
        } else if (n >= 3) {
            triboList.add(a);
            triboList.add(b);
            triboList.add(c);
            System.out.print(a + "\t" + b + "\t" + c);
        }

        for (int i = 4; i <= n; i++) {
            System.out.print("\t" + d);
            triboList.add(d);
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        System.out.println();

        System.out.println("Enter a number between 1 and " + n + " to print tribonacci number for that index.");
        int index = sc.nextInt();
        if (index < 1 || index > n) {
            System.out.println("Invalid index. Index can only be 1 to " + n);
        } else {
            System.out.println(triboList.get(index - 1));
        }
    } finally {
        if (sc != null) {
            sc.close();
        }
    }
}