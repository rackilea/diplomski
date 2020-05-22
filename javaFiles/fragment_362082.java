UnaryOperator<String> appender(String str) {
    StringBuilder sb = new StringBuilder(str);
    return s1 -> sb.append(s1).toString();
}

UnaryOperator<String> a1 = appender("foo");
UnaryOperator<String> a2 = appender("bar");
System.out.println(a1.apply("x"));
System.out.println(a1.apply("y"));
System.out.println(a2.apply("qq"));