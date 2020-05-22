int[] Number = new int[50];
    for (int i = 0; i < Number.length / 2; i++) {//first loop

        if (i % 10 == 0 && i > 0) {
            System.out.println();
        }
        System.out.print(i * i + " ");

    }

    for (int i = 25; i < Number.length; i++) {//second loop
        if (i % 10 == 0) {
            System.out.println();
        }
        System.out.print(i * 3 + " ");
    }