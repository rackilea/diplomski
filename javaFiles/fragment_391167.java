// Suppose list1, and list2 are initialized like this
List<? super Number> list1 = new ArrayList<Object>();  // valid assignment
List<? extends Integer> list2 = new ArrayList<Integer>();  // valid

// had this been valid, list1 and list2 both point to ArrayList<Integer>
list1 = list2;   

// This is fine, as list1 declared type is `List<? super Number>`
list1.add(new Float(2.4f));

// The below code will compile fine, as list2.get(0) type is Integer.
// But it would throw ClassCastException at runtime.
Integer in = list2.get(0);