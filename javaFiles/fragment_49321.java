package cs236369.proxy.types;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum HttpPatterns {
    RESPONSE_CODE("^HTTP/1\\.1 (\\d+) .*$"),
    CACHE_CONTROL("^Cache-Control: (\\w+)$"),
    HOST("^Host: (\\w+)$"),
    REQUEST_HEADER("(GET|POST) ([^\\s]+) ([^\\s]+)$"),
    ACCEPT_ENCODING("^Accept-Encoding: .*$"),
    CONTENT_ENCODING("^Content-Encoding: ([^\\s]+)$");

    private final Pattern pattern;

    HttpPatterns(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean matches(String expression) {
        return pattern.matcher(expression).matches();
    }

    public Object process(String expression) {
        Matcher matcher = pattern.matcher(expression);
        if (!matcher.matches()) {
            throw new RuntimeException("Called `process`, but the expression doesn't match. Call `matches` first.");
        }

        if (this == RESPONSE_CODE) {
            return Integer.parseInt(matcher.group(1));
        } else if (this == CACHE_CONTROL) {
            return CacheControl.parseString(matcher.group(1));
        } else if (this == HOST) {
            return matcher.group(1);
        } else if (this == REQUEST_HEADER) {
            return new RequestHeader(RequestType.parseString(matcher.group(1)), matcher.group(2), matcher.group(3));
        } else if (this == CONTENT_ENCODING) {
            return ContentEncoding.parseString(matcher.group(1));
        } else { //never happens
            return null;
        }
    }


}