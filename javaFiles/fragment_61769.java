else if (character == '+' || character == '-' || character == '*' || character == '/'){
    while (true) {
        char t = tmp.length() > 0 ? tmp.charAt(0): ' ';
        if (operatorCheck(t) < operatorCheck(character) || t == '(' || tmp.length() < 0) {
            break;
        }

        output += t;
        tmp = tmp.substring(1, tmp.length());
    }
    tmp = character + tmp;
}