public boolean isInDesiredFormat(String input) {
    try {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.ENGLISH);
        LocalDate.parse(input, format);
        return true;
    } catch (Exception ignore) {
        ignore.printStackTrace();
        return false;
    }
}