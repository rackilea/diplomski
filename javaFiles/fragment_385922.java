public class CaseInsensitiveAntPathMatcher extends AntPathMatcher {

@Override
public boolean match(String pattern, String string) {
    return super.match(pattern.toLowerCase(), string.toLowerCase()); // make this according to your need
}