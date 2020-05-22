import java.util.regex.*;

public boolean containsRepeatedCharacters(String input) {
    Pattern p = Pattern.compile("(.)\\1{9,}");
    Matcher m = p.matcher(input);

    return m.find();
}