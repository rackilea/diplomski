new Object[10].length; // returns 10

List<Object> list = new ArrayList<>(10);
list.size(); // returns 0

list.addAll(Collections.nCopies(10, null));
list.size(); // returns 10

new ArrayList<>(Collections.nCopies(10, null)).size(); // returns 10