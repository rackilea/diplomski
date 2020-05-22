List<String> list = new ArrayList<String>();
list.add("");

System.out.println("blah = " + list);  // displays "blah = []"
if (list.isEmpty()) {
    System.out.println("Empty"); // doesn't get displayed
}