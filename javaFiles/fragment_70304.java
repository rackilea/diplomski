String[] tests = {
        "org/com[2]/net[4]/uk@name",
        "org/com[2]/net[4]",
        "org/com[2/net",
        "org/com2]/net",
        "org/com[2]/net",
        "org/com[2]/net/",
        "org/com[2]/net@blah",
};

for (String test : tests)
    System.out.println(test + ": " + test.matches(pattern));