String s = "Hello, my name is Patrick and I have a lot to say, but I will tell you that another day.";
Matcher m = Pattern.compile("(.{1,20}(\\W|$))").matcher(s);
StringBuilder b = new StringBuilder();
while (m.find()) {
    b.append(m.group()).append("\n");
}
System.out.println("-> " + b.toString());