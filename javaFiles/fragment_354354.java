public static void main(String[] args) {
    int val;
    int evcounter = 0;
    int odcounter = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter total no of elements ");
    val = sc.nextInt();
    System.out.println("Enter values ");
    String[] n = new String[val];

    String[] eve = new String[(int) Math.ceil(val/2D)];
    String[] odd = new String[val/2];

    for (int i = 0; i < n.length; i++) {
        n[i] = sc.next();

        if (i % 2 == 0) {
            eve[evcounter] = n[i];
            evcounter++;
        } else {
            odd[odcounter] = n[i];
            odcounter++;
        }
    }
    System.out.println("Even array: " + Arrays.toString(eve));
    System.out.println("Odd array: " + Arrays.toString(odd));
}