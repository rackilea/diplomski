// Don't do this:
Set<String> setA = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
setA.add("hello");
setA.add("Hello");
System.out.println(setA);

Set<String> setB = new HashSet<String>();
setB.add("HELLO");
// Bad code; violates symmetry requirement
System.out.println(setB.equals(setA) == setA.equals(setB));