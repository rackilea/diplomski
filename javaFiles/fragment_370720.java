public Boolean isValideName(String nom) throws PatternSyntaxException {
    Pattern pattern = Pattern.compile("[A-Za-zÀ-ÿ '-]*");
    Matcher matcher = pattern.matcher(nom);
    boolean result = matcher.matches();
    return result;
}