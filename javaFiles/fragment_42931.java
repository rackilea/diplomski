public static int convertCharacter(String romanNumber, int position) {
    char c = romanNumber.charAt(position);
    switch (c) {
        case 'm':
            return 1000;
        case 'd':
            return 500;
        case 'c':
            return 100;
        case 'l':
            return 50;
        case 'x':
            return 10;
        case 'v':
            return 5;
        case 'i':
            return 1;
        default:
            return 0;
    }
}