for (int r = 1; input >= 0; ++r) {
    for (int c = 1; c <= r && input >= 0; ++c, --input) {
        System.out.print(input + " ");
    }
    System.out.println();
}