private static void CountLetters(Scanner sc) {
        System.out.println("Enter a string");
        String s = sc.nextLine();

        System.out.println("Enter a letter");
        char c = sc.nextLine().charAt(0);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                res++;
        }
        // Moved print statement outside of the loop; changed "i" to "in".
        System.out.println(res + " " + c + " in" + s);
    }