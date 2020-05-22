for (int i = 1; i <= input; i++) {
    String line = "";

    for (int k = 2; k >= 0; k--) {
        line += ((i >> k) & 1) == 1 ? "1" : "0";
    }

    System.out.println(line);
}