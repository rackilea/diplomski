public static void main(final String[] args) {
    final String input = "aaaab aOa baaab c";
    final String[] sections = input.split(" ");
    final int length = 3;

    final List<String> list = new ArrayList<>();
    for (final String section : sections) {
        for (int i = 0; i < section.length(); i++) {
            if (section.length() < length) {
                list.add(section);
                continue;
            }
            final int end = i + length;
            if (end > section.length()) {
                break;
            }
            final String result = section.substring(i, end);
            list.add(result);
        }
    }
    list.stream().forEach(s -> System.out.println(s));
}