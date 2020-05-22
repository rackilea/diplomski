List<String> values = Arrays.asList("test => Test",
            "test start now => Test start now.",
            "2test start now => 2test start now",
            "_test => _test",
            "-test => -test");

    @Test
    public void firstLetterUpperCase() {
        // Iterate the values
        values.stream()
                // Check if the first char is Alphabetic
                .filter(text -> Character.isAlphabetic(text.charAt(0)))
                // Capital first letter and print
                .forEach(text -> System.out.println(text.substring(0, 1).toUpperCase() + text.substring(1)));
    }