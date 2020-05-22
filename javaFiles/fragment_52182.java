public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Prompt the user for how many integers are going to be entered

    System.out.print("*Please write how many numbers are going to be entered: ");

    if (scan.hasNextInt()) {
        int a = scan.nextInt();
        int[] n = new int[a];

        for (int i = 0 ; i < a ; i++) {
            System.out.print("*Please enter an enteger: ");
            if (scan.hasNextInt()) {
                n[i] = scan.nextInt();

            } else {
                System.out.print("*Sorry your entery was not correct. Please enter digits only. ");
                break;
            }
        }// for
    } else {
        System.out.print("*Sorry your entery was not correct. Please enter digits only. ");
    }

}