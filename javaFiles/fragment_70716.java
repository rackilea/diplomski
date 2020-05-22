Scanner keyboard = new Scanner(System.in);
    System.out.print("Provide an input sentence: ");
    String userInput = keyboard.nextLine();
    StringTokenizer strTokenizer = new StringTokenizer(userInput, " ", true);
    System.out.print("The output sentence is   : ");
    while (strTokenizer.hasMoreTokens()) {
        String str = strTokenizer.nextToken();
        StringBuilder blob = new StringBuilder(str);
        System.out.print(blob.reverse());
    }

    System.out.print("\n");
 }