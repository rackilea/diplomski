char top;
try {
    top = operators.peek();
} catch (EmptyStackException e2) {
    operators.push(character);
    continue;
}

if (getValue(character) > getValue(top)) {
    operators.push(character);
    continue;
} else {
    try {
        while (!(getValue(character) > getValue(operators.peek()))) {
            char operator;

            operator = operators.pop();

            int i = numbers.pop();
            int j = numbers.pop();

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
    } catch (EmptyStackException e3) {
        operators.push(character);
        continue;
    }