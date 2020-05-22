// Init replacement map
Map<Matcher, String> replacementMap = new HashMap<Matcher, String>() {
    {
       // Put your replacement rules here...
       put(m("regex1"), "replacement1");
       put(m("regex2"), "replacement2");
       // ...
    }

    // Helper method for quickly creating a matcher and improve code readability
    private Matcher m(String regex) {
        return Pattern.compile(regex).matcher("");
    }
};

// Load source string
String source = loadSourceString();

// Perform replacements
for(Map.Entry<Matcher, String> e: replacementMap.entrySet()) {
    e.getKey().reset(source).replaceAll(e.getValue());
}