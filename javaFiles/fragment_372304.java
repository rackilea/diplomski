String input = "(123456) LastName, FirstName MiddleName";
String regex = "\\(([^)]*)\\)\\s*([^,]+),\\s*(\\S+)\\s*(\\S*)";
Matcher m = Pattern.compile(regex).matcher(input);
if (m.matches()) {
    System.out.println("empNo = " + m.group(1));
    System.out.println("lName = " + m.group(2));
    System.out.println("fName = " + m.group(3));
    System.out.println("mName = " + m.group(4));
}