private static String validateText() {
    String text = getText();
    log("in validate= " + text + "");
    char[] tc = text.toCharArray();

    for (char t : tc) {
        if (Character.isLetter(t)) {
            log("character = " + t);
        }
        else {
            System.out.println("Error occured, non alphabet found in text");
            log("error = " + t);
            log("validate returned " + text);
            return validateText();
        }
    }
    return text;
}