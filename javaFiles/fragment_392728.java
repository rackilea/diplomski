private boolean isContain(String source, String subItem) {
    String pattern = "(?m)(^|\\s)" + subItem + "(\\s|$)";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(source);
    return m.find();
}