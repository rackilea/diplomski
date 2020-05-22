public static void main(String[] args) {
        char[] alphabet = new char[] {'a','b','c'};
        possibleStringsOfLengthK(4, alphabet, "");
    }
    public static void possibleStringsOfLengthK(int maxLength, char[] alphabet, String currentValue) {
        if(currentValue.length() == maxLength) {
            System.out.println(currentValue);
        } else {
            for(int i = 0; i < alphabet.length; i++) {
                String oldValue = currentValue;
                currentValue += alphabet[i];
                possibleStringsOfLengthK(maxLength, alphabet, currentValue);
                currentValue = oldValue;
            }
        }
    }