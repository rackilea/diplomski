list.add(Integer.valueOf(42)); // adding an Integer
list.add("aaa"); // adding a String

Object something = list.get(0); // unknown type of returned object, need to cast
Integer i0 = (Integer) something; // this unsafe cast works...
Integer i1 = (Integer) list.get(1); // but this fails with a ClassCastException
// because you cannot cast a String to Integer