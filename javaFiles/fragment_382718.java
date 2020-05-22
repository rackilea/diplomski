public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    String lines[] = new String[n];
    for (int i = 0; i < n; i++) {
        System.out.println("Enter " + i + "th line");
        lines[i] = scan.nextLine();
    }
}