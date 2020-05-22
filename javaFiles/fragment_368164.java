String str = " 9926 9928 9951 9953 0 30 57 12 40 54 30";

Matcher m = Pattern.compile("99\\d{2}").matcher(str);

while (m.find())
    System.out.println(m.group());