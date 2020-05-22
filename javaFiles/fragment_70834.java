public interface CommentDelimiter {
    String getStartPattern();
    String getEndPattern();
}

public interface CommentDetector {
    boolean commentStartsAt(int index, String sourceCode);
    boolean commentEndsAt(int index, String sourceCode);
}

public enum CommentDetectors implements CommentDetector {
    JAVA_MULTILINE(CommentDelimiters.JAVA_MULTILINE),
    JAVA_SINGLELINE(CommentDelimiters.JAVA_SINGLELINE);

    // ... store commentDelimiter

    public boolean commentStartsAt(int index, String sourceCode) {
        // ... using commentDelimiter.getStartPattern()
    }

    public boolean commentEndsAt(int index, String sourceCode) {
        // ... using commentDelimiter.getEndPattern()
    }
}

public enum CommentDelimiters implements CommentDelimiter {
    JAVA_MULTILINE("/*", "*/"),
    JAVA_SINGLELINE("//", "\n");

    // ... store start, end
}