String[] tests = { 
        "My name is Fred",
        "My name is Fred.",
        "Hi, My name is Fred.",
        "Hey, I am Fred!",
};

Pattern p = Pattern.compile("\\b([A-Z][a-z]+)[^\\w]*$");
for (String test : tests) {
    Matcher m = p.matcher(test);
    m.find();
    System.out.println(m.group(1));
}