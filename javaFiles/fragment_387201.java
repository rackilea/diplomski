public int convert(String userInput) {
        userInput = userInput.toUpperCase();
        int result = 0;
        int subtractamount = 0;
        int x = userInput.length() - 1;
        while (x != 0) {
            char romanConvert = userInput.charAt(x);
            if (x >= 1) {
                if (convertChar(romanConvert) >= convertChar(userInput.charAt(x - 1))) {
                    subtractamount += convertChar(userInput.charAt(x - 1));
                }
            }
            result += convertChar(romanConvert);
            x--;

        }
        result -= subtractamount;
        return result;

    }