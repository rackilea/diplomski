public void drawTriangle(int height) {
    System.out.println("A Pascal Triangle with height " + height);
    for (int i = 0; i <= height; i++) {
        int number = 1;
        if (i != height)
            System.out.format("%" + ((height - i) * 2) + "s", " ");

        for (int j = 0; j <= i; j++) {
            if (j == 0)
                System.out.print(number);
            else
                System.out.format("%4d", number);
            number = number * (i - j) / (j + 1);

        }
        System.out.println();
    }
}