public class MyPattern {
    public String category;
    public String regex;
    public Pattern pattern;

    public Pattern getPattern() {
        if(pattern == null) {
            pattern = Pattern.compile(regex);
        }
        return pattern;
    }
}