public static char convertChar(char value) {
    char result;
    switch (value) {
        case 'I':
            result = 1;
            break;
        case 'V':
            result = 5;
            break;
        case 'X':
            result = = 10;
            break;
        case 'L':
            result = 50;
            break;
        case 'C':
            result = 100;
            break;
        case 'D':
            result = 500;
            break;
        case 'M':
            result = 1000;
            break;
        default:
            System.out.println("Invalid character!");
            result = 0;
            break;
                   }
        return result
}