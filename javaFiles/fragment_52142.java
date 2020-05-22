public static long numbGen() {
    while (true) {
        long numb = (long)(Math.random() * 100000000 * 1000000); // had to use this as int's are to small for a 13 digit number.
        if (String.valueOf(numb).length() == 13)
            return numb;
    }
}