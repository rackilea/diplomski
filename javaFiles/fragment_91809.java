private static List<String> generate_$() {
    List<String> returnValue = new LinkedList<String>();
    Exception[] exceptions = { new ClassCastException(),
            new NullPointerException(), new IOException("foo") };
    for (Exception exception : exceptions) {
        try {
            throw exception;
        } catch (Exception e) {
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            returnValue.add(writer.getBuffer().toString());
        }
    }
    return returnValue;
}

public static void main(String[] args) {
    List<String> examples = generate_$();
    for (String trace : examples) {
        Pattern headLinePattern = Pattern.compile("([\\w\\.]+)(:.*)?");
        Matcher headLineMatcher = headLinePattern.matcher(trace);
        if (headLineMatcher.find()) {
            System.out.println("Headline: " + headLineMatcher.group(1));
            if (headLineMatcher.group(2) != null) {
                System.out.println("Optional message "
                        + headLineMatcher.group(2));
            }
        }
        // "at package.class.method(source.java:123)"
        Pattern tracePattern = Pattern
                .compile("\\s*at\\s+([\\w\\.$_]+)\\.([\\w$_]+)(\\(.*java)?:(\\d+)\\)(\\n|\\r\\n)");
        Matcher traceMatcher = tracePattern.matcher(trace);
        List<StackTraceElement> stackTrace = new ArrayList<StackTraceElement>();
        while (traceMatcher.find()) {
            String className = traceMatcher.group(1);
            String methodName = traceMatcher.group(2);
            String sourceFile = traceMatcher.group(3);
            int lineNum = Integer.parseInt(traceMatcher.group(4));
            stackTrace.add(new StackTraceElement(className, methodName,
                    sourceFile, lineNum));
        }
        System.out.println("Stack: " + stackTrace);

    }
}