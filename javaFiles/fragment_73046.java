private static final Pattern SPACES_OR_EMPTY = Pattern.compile(" *");
public static String implode(String separator, String... data) {
    StringJoiner sb = new StringJoiner(separator);
    for (String token : data) {
        if (!SPACES_OR_EMPTY.matcher(token).matches()) {
            sb.add(token);
        }
    }
    return sb.toString();
}