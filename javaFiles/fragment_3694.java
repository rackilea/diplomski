public double doCalculation(String input) throws DataFormatException {
    if (input == null) {
        return 0;
    }

    char[] characters = input.toCharArray();

    for (char character: characters) {
        try {
            // tries to push the number onto the number stack
            numbers.push(Integer.parseInt("" + character));

        } catch (NumberFormatException e1) {
            // if this is caught, this means the character is non-numerical
            operators.push(character);

        }
    }

    while (operators.size() > 0) {
        int i = numbers.pop();
        int j = numbers.pop();
        char operator = operators.pop();

        switch (operator) {
            case '+':
                numbers.push(j + i);
                break;
            case '-':
                numbers.push(j - i);
                break;
            case '*':
                numbers.push(j * i);
                break;
            case '/':
                numbers.push(j / i);
                break;
            case '^':
                numbers.push((int)(Math.pow(j, i)));
                break;
            default:
                throw new DataFormatException();
        }
    }

    return numbers.pop();
}