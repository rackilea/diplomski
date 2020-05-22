public static void main(String[] args) {
    String str = "BBA987462HBBA84536BBA647";
    String regexWhole = "BBA\\d{1,7}\\w?";
    String regexOne   = "(?<=BBA)|(?<=BBA\\d{3})|(?<=BBA\\d{5})|(?<=BBA\\d{6})";
    Pattern pattern   = Pattern.compile(regexWhole);
    List<String> res  = new ArrayList<>();

    Matcher m = pattern.matcher(str);
    while (m.find()) {
        String find = m.group();
        res.add(String.join(" ", find.split(regexOne)));
    }

    System.out.println(res);  // [BBA 987 46 2 H, BBA 845 36, BBA 647]
}