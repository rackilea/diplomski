Node node = new Node();
node.add("x", 123);
node.add("y", "ABC");
node.add("z", new Date());

int    valueX = node.get("x"); // cast to integer and autobox to int
String valueY = node.get("y"); // cast to String
Date   valueZ = node.get("z"); // cast to Date

String valueFail = node.get("z"); // this will throw a ClassCastException