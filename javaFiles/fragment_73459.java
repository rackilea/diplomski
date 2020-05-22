for (int i = 0, s = 0, n = 0; i < input.length; i++) {
        if (NumberUtils.isNumber(input[i])) {
            input[i] = Integer.toString(numbers.get(n++));
        } else {
            input[i] = strs.get(s++);
        }
    }