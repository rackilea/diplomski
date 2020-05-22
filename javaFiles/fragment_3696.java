public int getValue(char character)
throws DataFormatException {
    switch (character) {
        case '+':
            return 1;
        case '-':
            return 1;
        case '*':
            return 2;
        case '/':
            return 2;
        case '^':
            return 3;
        default:
            throw new DataFormatException();
    }

}