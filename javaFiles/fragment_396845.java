// just for constructing a sample list
String str = "Kobe Is is The the best player In in Basketball basketball game .";
List<String> list = new ArrayList<>(Arrays.asList(str.split("\\s")));

// the actual operation
TreeSet<String> seen = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
list.removeIf(s -> !seen.add(s));

// just for debugging
System.out.println(String.join(" ", list));