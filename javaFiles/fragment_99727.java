public static boolean validAnswer(String answer) {
    if (answer!=null && (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
        return true;
    }
    return false;
}