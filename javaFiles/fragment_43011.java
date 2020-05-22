private boolean isDigit(String text) {
    try {
        Integer.parseInt(text);
        return true;
    } catch (NumberFormatException e) {
        // log warning, track analytics if you want
    }
    return false;
}