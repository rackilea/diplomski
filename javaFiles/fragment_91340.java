public static void revNumbers(Scanner in) {
    if(!in.hasNextInt())
        return;
    int X = in.nextInt();
    revNumbers(in);
    System.out.println(X);
}

public static void main(String[] args) {
    revNumbers(new Scanner(System.in));
}