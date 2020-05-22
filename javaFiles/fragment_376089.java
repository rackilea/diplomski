String s = ">=date";
Pattern pattern = Pattern.compile("(>=?)(\\w+)");
Matcher matcher = pattern.matcher(s);
matcher.find();

System.out.println(String.valueOf(matcher.group(1)));
System.out.println(String.valueOf(matcher.group(2)));

System.out.printf(" {\"%s\", \"%s\"}", matcher.group(1), matcher.group(2));

        //>=
        //date
        //{">=", "date"}