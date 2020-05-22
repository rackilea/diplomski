@Test
public void test() {
    final String text =
        "header line 1\n" +
        "header line 2\n" +
        "header line 3\n" +
        "\n" +
        "line 1\n" +
        "line 2\n" +
        "line 3";
    MatcherAssert.assertThat(
        new Mapped<>(
            txt -> txt.asString(),
            new Skipped<>(
                new SplitText(
                    text,
                    "\n"
                ),
                4
            )
        ),
        Matchers.contains("line 1", "line 2", "line 3")
    );
}