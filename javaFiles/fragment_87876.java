public static void main(String[] args) {
    String txt = "a3b10";
    String patt = "([a-z])([0-9]*)"; // ([a-z]) will be the first group and ([0-9]*) will be the second

    Pattern pattern = Pattern.compile(patt);
    Matcher matcher = pattern.matcher(txt);

    while(matcher.find()) {
        String letter = matcher.group(1);
        String number =  matcher.group(2);
        int num = Integer.valueOf(number);
        while (num > 0) {
            System.out.print(letter);
            num--;
        }
    }
}