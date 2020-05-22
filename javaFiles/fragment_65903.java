public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    int n = sc.nextInt();  // no of strings

    String result = sc.next().toLowerCase();
    String s;
    while(n-- > 1) {
        s = sc.next().toLowerCase();
        result = intersectionOf(result, s);
    }
    for(char c : result.toCharArray())
        System.out.println(c);
}