private void testMethod(){
    String input = "(0, 0) (1, 3) (4, 4) (4, 2) (4, 2) (0, 1) (3, 2) (2, 3) (4, 1)";
    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();

    Pattern pattern = Pattern.compile("\\((.*?)\\)");
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
        String[] sa = matcher.group(1).split(",");
        x.add(Integer.valueOf(sa[0].trim()));
        y.add(Integer.valueOf(sa[1].trim()));
    }
}