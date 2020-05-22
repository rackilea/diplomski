String regex="\\d+\\.?\\d*|\\d*\\.?\\d+";

System.out.println("1".matches(regex));   // true
System.out.println("1.00".matches(regex));// true
System.out.println(".1".matches(regex));  // true
System.out.println("1.".matches(regex));  // true

System.out.println(".".matches(regex));   // false