public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a uncoded string: ");
        String first = sc.nextLine();
        if (first.charAt(0) == 'i') {
            first = first.toUpperCase();
        }
        System.out.println("The decoded string is: " + first );
    }