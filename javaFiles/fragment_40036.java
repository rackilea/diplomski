Pattern pat = Pattern.compile("([^|]+(?:\\|.+)?)");

for (int i=0; i < strings.length; i++) {
    Matcher m = pat.matcher(strings[i]);
    while (m.find()) 
        if (m.group(1).contains("|"))
            list.add("\"".concat(m.group(1)).concat("\""));
        else
            list.add(m.group(1));
}