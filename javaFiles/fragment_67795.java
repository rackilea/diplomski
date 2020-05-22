List<String> list1ref1 = new ArrayList<>(); // <-- only one instance created
List<String> list1ref2 = list1ref1; // <-- second reference to same instance

// both variables reference the same instance of the object
// thus they both 'add' to the same instance
list1ref1.add("1");
list1ref2.add("2");

System.out.println(list1ref1); // [1, 2]
System.out.println(list1ref2); // [1, 2]

// 'list1ref2' now does not reference any instance, aka null
list1ref2 = null;

// but `list1ref1` still references that original instance
System.out.println(list1ref1); // [1, 2]
System.out.println(list1ref2); // null