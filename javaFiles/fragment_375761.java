public final class MatchRegex {
    private final String regex;
    private final Pattern pattern;

    private MatchRegex(String regex) { 
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }
    public static MatchRegex of(String regex) { 
        return new MatchRegex(regex);
    }
    public boolean matches(String input) { 
        return pattern.matcher(input).matches();
    }
    public String getRegex() { 
        return regex;
    }
}