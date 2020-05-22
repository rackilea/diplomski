for (int i = 1; i <= word.length(); i++) {
        for (int j = 0; j < i; j++) {
            System.out.print(word.substring(0, i));
        }
        System.out.println("");
    }