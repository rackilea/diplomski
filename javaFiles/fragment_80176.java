public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.print("Please enter a sequence of 1's and 0's");
    String binInput = scan.nextLine();
//        System.out.println(binaryToDecimal(binInput));

    char c;
    for (int j = 0; j < binInput.length(); j++) {
        c = binInput.charAt(j);
        if (!(c == '0' || c == '1')) {
            System.out.print("Error");
        }
    }