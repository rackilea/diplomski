/**
 * Gets the three matched groups of the {@code regex} from the {@code original}.
 *
 * @param regex    a {@link Pattern} that should have three groups in it and
                   match the {@code original}
 * @param original the string we'll match with the {@code regex}
 * @return a {@link Tuple3} of the three matched groups or {@link Option#none} if
 *         the {@code regex} did not match
 */
static Option<Tuple3<String, String, String>> getGroups3(Pattern regex,
                                                         CharSequence original) {
    var matcher = regex.matcher(original);
    return matcher.matches() && matcher.groupCount() == 3 ?
            Some(Tuple.of(matcher.group(1), matcher.group(2), matcher.group(3))) :
            Option.none();
}