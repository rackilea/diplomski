public static void main(String[] args) {
    Pattern pattern = Pattern.compile("([\\d\\.]+)\\s+(.*)", Pattern.MULTILINE | Pattern.DOTALL);

    List<String> input = Arrays.asList(
            "3.7.2 sealant durability",
            "3.7.3 funkční schopnost",
            "3.1.14 plastic sealant xx 21",
            "3.1.14 plastic sealant\n" +
                    "xx 21",
            "3.7.12 sealant durability",
            "3.7.325 funkční schopnost");

    for (String s : input) {
        Matcher matcher = pattern.matcher(s);
        System.out.println("Input:" + s);
        if (matcher.matches()) {
            System.out.println("Number: " + matcher.group(1));
            System.out.println("Title: '" + matcher.group(2)+"'");
        }
        System.out.println();
    }
}