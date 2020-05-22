public static boolean isMatch(String model, String input) {

    int nbCharacterRemaningToFind = input.length();
    String copyModel = model;

    for (char c : input.toCharArray()) {
        String cInString = String.valueOf(c);

        if (copyModel.contains(cInString)) {
            copyModel = copyModel.replaceFirst(cInString, "");
            nbCharacterRemaningToFind--;
            if (nbCharacterRemaningToFind == 0) {
                return true;
            }
        }

    }

    return false;
}