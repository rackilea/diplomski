String toIndex = "A=1,B=2,C=3,D=4,E=5";
    Pattern p = Pattern.compile("[0-9]+");
    Matcher m = p.matcher(toIndex);
    while (m.find()) {
        System.out.println(m.group());
    }