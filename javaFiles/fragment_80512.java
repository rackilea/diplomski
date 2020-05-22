String text  = "This is the text 2432423 which contains phone numbers 56565555";

Pattern pattern = Pattern.compile("\\d{5,12}"); // at least 5 at most 12
// before match remove all the spaces, to ensure the length on numbers is OK it will work more better. 
Matcher matcher = pattern.matcher(text.replaceAll(" ", ""));
while (matcher.find()) {
    String num = matcher.group();
    System.out.println("phone = " + num);
}