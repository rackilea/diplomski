Pattern p = Pattern.compile("([^,]*),([0-9]|10),([0-9]|10),([0-9]|10),([0-9]|10),([0-9]|10),([0-9]|10)");
for (String line : lines) {
    Matcher m = p.matcher(line);
    if (! m.matches()) {
        System.out.println("Invalid line: " + line);
    } else {
        System.out.println("Name: " + m.group(1));
        System.out.println("  Values: " + m.group(2)
                                  + " " + m.group(3)
                                  + " " + m.group(4)
                                  + " " + m.group(5)
                                  + " " + m.group(6)
                                  + " " + m.group(7));
    }
}