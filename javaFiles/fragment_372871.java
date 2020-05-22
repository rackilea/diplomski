String s = "wo'rd w'ord wo'r'd";
Matcher m = Pattern.compile("\\b(\\w)(\\w*)'(\\w(?:'\\w)*)").matcher(s);
System.out.println(
    m.replaceAll(r -> r.group(1).toUpperCase()+r.group(2) + "'" + r.group(3).toUpperCase())
);
//wo'rd w'ord wo'r'd => Wo'Rd W'Ord Wo'R'D
//word w'ord wo'rd => word W'Ord Wo'Rd