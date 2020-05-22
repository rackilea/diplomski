public static String encode(String input) {
    Pattern doNotReplace = Pattern.compile("[a-zA-Z0-9]");

    return input.chars().mapToObj(c->{
        if(!doNotReplace.matcher(String.valueOf((char)c)).matches()){
            return "%" + (c<256?Integer.toHexString(c):"u"+Integer.toHexString(c));
        }
        return String.valueOf((char)c);
    }).collect(Collectors.joining("")).toUpperCase();
}