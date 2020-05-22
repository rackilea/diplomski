public static void main(String[] args) {
    List<String> data = new ArrayList(Arrays.asList(
        "name='Anything can go here'",
        "name = \"Really!  Anything can go here\""
    ));

    for (String d : data) {
        Matcher matcher = Pattern.compile("[\"'](.+)[\"']").matcher(d);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}