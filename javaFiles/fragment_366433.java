public static String unique(final String string){
    final StringBuilder builder = new StringBuilder();
    for(final char c : string.toCharArray())
        if(builder.indexOf(Character.toString(c)) == -1)
            builder.append(c);
    return builder.toString();
}