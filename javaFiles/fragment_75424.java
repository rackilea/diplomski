String[] queries = { "abc", // -> false
    "165-45", // -> true
    "ab3b", // -> true
    "1231asdf", // -> true
    "asdfasd123213", // -> true
    "12-465", // -> true
    "ASDSAD" // -> false
};
Pattern p = Pattern.compile("\\d");
for (String s : queries) {
    System.out.println(p.matcher(s).find());
}