private void drawDimond(int size) {
        System.out.print("\n");

        // for the top cover
        System.out.print("+");
        for (int i = 0; i < size * 2 - 1; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        //first half
        for (int i = 1; i < size; i++) {
            System.out.print("|");

            for (int j = 0; j < size - i; j++) {
                System.out.print("-");
            }
            for (int k = 0; k < i * 2 - 1; k++) {
                System.out.print("*");
            }
            for (int j = 0; j < size - i; j++) {
                System.out.print("-");
            }

            System.out.println("|");

        }

        //middle line
        System.out.print("|");
        for (int i = 0; i < size * 2 - 1; i++) {
            System.out.print("*");
        }
        System.out.println("|");

        //second half
        for (int i = 1; i < size; i++) {
            System.out.print("|");

            for (int j = 0; j <= (i * 2 - 1) / 2; j++) {
                System.out.print("-");
            }
            for (int k = 0; k < (size - i) * 2 - 1; k++) {
                System.out.print("*");
            }
            for (int j = 0; j <= (i * 2 - 1) / 2; j++) {
                System.out.print("-");
            }

            System.out.println("|");

        }

        // For the bottom
        System.out.print("+");
        for (int i = 0; i < size * 2 - ((size + 1) % 2); i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }