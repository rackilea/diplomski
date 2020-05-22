String email = "as@as.com";
List<String> list = Arrays.asList(email);

list.set(0, "bs@bs.com"); // OK
list.clear();             // throws UnsupportedOperationException
list.add("cc@cc.com");    // throws UnsupportedOperationException