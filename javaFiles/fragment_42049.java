System.out.println("JVM default=" + TimeZone.getDefault().getID()); // America/Sao_Paulo
DateTimeZone t1 = DateTimeZone.getDefault();
System.out.println("Joda Default=" + t1); // America/Sao_Paulo

// setting the default timezone to London
TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
System.out.println("JVM default=" + TimeZone.getDefault().getID()); // Europe/London
DateTimeZone t2 = DateTimeZone.getDefault();
System.out.println("Joda Default=" + t2); // America/Sao_Paulo
System.out.println(t1 == t2);  // true