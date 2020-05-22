for (int i = 0; i < num; i++) {
    for (int j = 0; j <= (num - counter); j++) {
        System.out.print(" ");
    }

    for (int k = 0; k < counter; k++) {
        System.out.print("*");
    }

    System.out.println("");

    counter++;
}