String allowedCharacters = "123456789abcdef";

allowedCharacters.contains("a"); // true
allowedCharacters.contains("g"); // false
allowedCharacters.contains(String.valueOf(5)); // true
allowedCharacters.contains(String.valueOf(-1)); // false