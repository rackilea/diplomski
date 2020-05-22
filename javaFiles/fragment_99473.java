String input = "abcde";
    Map<Character, Character> encodedChar = new HashMap<Character, Character>();

    encodedChar.put('a', 'c');
    encodedChar.put('b', 'e');

    char[] tempInput = input.toCharArray();

    for (int i = 0; i < tempInput.length; i++) {
        tempInput[i] = encodedChar.get(tempInput[i]);
    }
    input = new String(tempInput);