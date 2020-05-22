public static boolean isValidModuleName(String name) {
    String VALID_REGEX = "([\\p{L}_$][\\p{L}\\p{N}_$]*\\.)*[\\p{L}_$][\\p{L}\\p{N}_$]*";


    if (!name.matches(VALID_REGEX))
        return false;


    Set<String> keywords = Set.of("abstract", "continue", "for", "new", 
                    "switch", "assert", "default", "goto", "package",
                    "synchronized", "boolean", "do", "if", "private", "this",
                    "break", "double", "implements","protected", "throw", 
                    "byte", "else", "import", "public", "throws", "case", 
                    "enum", "instanceof", "return", "transient", "catch", 
                    "extends",  "int", "short", "try", "char", "final",
                    "interface", "static", "void", "class", "finally", 
                    "long", "strictfp", "volatile", "const",
                    "float", "native", "super", "while", "module", "open", 
                    "opens", "exports", "requires",
                    "transitive", "to", "with", "provides", "uses");


    String[] tokens = name.split("\\.");
    for (String t : tokens) {
        if (keywords.contains(t))
            return false;
    }

    return true;
}