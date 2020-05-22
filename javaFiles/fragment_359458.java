for (int i = 0; i < 52; i++) {
        String suit = suits[i / 13];
        String rank = ranks[i % 13];
        System.out.print(rank + suit + " ");
        if ((i + 1) % 13 == 0) {
            System.out.println();
        }
    }