public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);

    System.out.print("Please enter a message: ");
    String message = input.nextLine();
    System.out.print("Please enter a value for coding: ");
    int codeNumber = input.nextInt();

    System.out.println(getMsg(message, codeNumber));
}

public static String getMsg(String message, int codeNumber) {
    char[] characters = message.toCharArray();

    for (int i = 0; i < characters.length; i++) {
        for (int j = 0; j < codeNumber; j++) {
            int charCode = characters[i] + 1;
            // Only apply the modification to letters or numbers
            if (Character.isUpperCase(characters[i])) {
                characters[i] = charCode > 'Z' ? 'A' : (char)charCode;
            } else if (Character.isLowerCase(characters[i])) {
                characters[i] = charCode > 'z' ? 'a' : (char)charCode;
            } else if (Character.isDigit(characters[i])) {
                characters[i] = charCode > '9' ? '0': (char)charCode;
            }
        } 
    }  
    return new String(characters);
}