Pattern p = Pattern.compile("\\d{1,3}(,?\\d{3})*"); // You can store this as static final
Matcher m = p.matcher(input);
while (m.find()) { // Go through all matches
    String num = m.group().replace(",", "");
    int n = Integer.parseInt(num);
    // Do stuff with the number n
}