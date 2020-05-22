for(;;) {
        System.out.println("Enter an Alphabet");
        char ch = sc.next().charAt(0);
        if (ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u') {
            System.out.println("This is a vowel");
        } else if (Character.isLetter(ch)) {
             System.out.println("This is a consonant");
        }
      }