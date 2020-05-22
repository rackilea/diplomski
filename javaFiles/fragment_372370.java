public String addCommasToNumericString(String digits) {
    String result = "";
    for (int i=1; i <= digits.length(); ++i) {
        char ch = digits.charAt(digits.length() - i);
        if (i % 3 == 1 && i > 1) {
            result = "," + result;
        }
        result = ch + result;
    }

    return result;
}

addCommasToNumericString("123");     // 123
addCommasToNumericString("12345");   // 12,345
addCommasToNumericString("1234567"); // 1,234,567