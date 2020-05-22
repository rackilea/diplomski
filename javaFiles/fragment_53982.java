public static void main(String[] args) {
    Pattern pattern = Pattern.compile("^-?([^\\.]+\\.){1,2}\\((\\d+-\\d+|\\d+)|([^|]+|[^|]+)\\)$");
    String[] samples = { "world.block.(1-2|1).(test1|stack)",
        "test.test.(1-2|1)",
        "world.(test1|stack)",
        "-help.block.(1-2|1).(test1|stack)",
        "-world.help",
        "world.stack",
        "world.block."
    };

    for (String sample : samples) {
        Matcher matcher = pattern.matcher(sample);
        System.out.println(sample + (matcher.find() ? " matched" : " failed"));
    }
}