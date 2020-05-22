String regex = "\\d+";

// positive test cases, should all be "true"
System.out.println("1".matches(regex));
System.out.println("12345".matches(regex));
System.out.println("123456789".matches(regex));

// negative test cases, should all be "false"
System.out.println("".matches(regex));
System.out.println("foo".matches(regex));
System.out.println("aa123bb".matches(regex));