/* Say getResponse() taps into a third-party library that has a quirk:
 * a response object must be consumed entirely before being closed. */
try(@MustConsumeEntirely Stream<String> lines = getResponse()) {
    lines.findFirst().ifPresent(System.out::println);
    /* The stream is not entirely consumed (unless it is only 1 line but there is no way to tell).
     * A smart checker could catch this and issue a warning. */
}