public House createHouse(String n) {
    Matcher m = Pattern.compile("(^\\d+)(.*)").matcher(n);

    if(!m.find()) {
        throw new Exception("Number must start with a digit!");
    }

    int number = Integer.parseInt(m.group(1));
    String subNumber = m.group(2);

    return new House(number, subNumber);
}