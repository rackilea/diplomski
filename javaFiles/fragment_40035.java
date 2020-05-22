for (int i=0; i < strings.length; i++) {
    if (strings[i].equals("|"))
        continue;
    StringBuilder builder = new StringBuilder(strings[i]);
    if (strings[i].startsWith("|"))
        builder.deleteCharAt(0);
    if (strings[i].endsWith("|"))
        builder.deleteCharAt(builder.length()-1);
    if (builder.indexOf("|") != -1)
        builder.append("\"").insert(0, "\"");
    list.add(builder.toString());
}