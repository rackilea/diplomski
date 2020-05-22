import java.util.Pattern
import java.util.Matcher

Pattern status = Pattern.compile("\\[.*] \\w+:\\s+-> (\w+).*");

...