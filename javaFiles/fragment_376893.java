class SplitLineAnalyzer {

    public List<String> extractParameters(String line) {
        final String regex = "'";
        final String[] split = line.split(regex);
        if (split.length % 2 == 0) {
            System.out.println("Line contains unexpected number of parts. Hard to guess pattern for line = " + line);
            return Collections.emptyList();
        }

        List<String> args = new ArrayList<>();
        for (int i = 1; i < split.length; i += 2) {
            args.add(split[i]);
            split[i] = "%s";
        }

        Arrays.stream(split).reduce((s1, s2) -> s1 + regex + s2).ifPresent(s -> System.out.println("Possible pattern: " + s));

        return args;
    }
}