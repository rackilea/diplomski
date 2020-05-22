String s = "Green (Low): 20";
Matcher m = Pattern.compile("[-+]?\\d+").matcher(s);
if (m.find())
    int number = Integer.parseInt(m.group());
    if (number <= 26 && number >= 11) {
        System.out.println("Contains number between 11 and 26!");
    } else {
        System.out.println("Contains number but not between 11 and 26!");
    }
} else {
    System.out.println("Contains no numbers");
}