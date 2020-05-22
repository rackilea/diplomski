public static char getCheckDigit(String isbn) {
    if (isbn == null || !isbn.matches("[0-9]{9,}")) {
        throw new IllegalArgumentException("Illegal ISBN value");
    }

    int sum = 0;

    for (int i = 0; i < 9; i++) {
        sum += ((10 - i) * Character.digit(isbn.charAt(i), 10));
    }

    int check = ((11 - (sum % 11)) % 11);

    return check == 10 ? 'X' : Character.forDigit(check, 10);
}