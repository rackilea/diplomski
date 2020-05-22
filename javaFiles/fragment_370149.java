if (ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u') {
            System.out.println("This is a vowel");
        } else if (Character.isLetter(ch)) {
             System.out.println("This is a consonant");
        } else {
          break; // exit the loop.
        }