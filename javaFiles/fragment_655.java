int i = 1;
    for (int x = 0; x<items.length; x++) {
        if (x == i) {
            System.out.printf("%5s", "i");
        }
        else {
            System.out.printf("%5s", "");
        }
    }
    System.out.println();