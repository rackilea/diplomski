public static void main(String[] args) {
    String input = "From foo@gmail.com Fri Jan 5 09:14:16 2016";

    Pattern p = Pattern.compile("(?<=@)(\\w+(\\.\\w+)+)");
    Matcher m = p.matcher(input);

    while (m.find()) {
        System.out.println("Found a " + m.group(1) + ".");
    }
}