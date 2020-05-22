Set<CaselessString> set1 = new HashSet<CaselessString>();
set1.add(CaselessString.as("Hello"));
set1.add(CaselessString.as("HELLO"));

Set<CaselessString> set2 = new HashSet<CaselessString>();
set2.add(CaselessString.as("hello"));

System.out.println("1: " + set1);
System.out.println("2: " + set2);
System.out.println("equals: " + set1.equals(set2));