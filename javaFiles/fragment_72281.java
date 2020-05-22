GenericList<Integer> arr = new GenericList();
list.add(27);

try {

    list.get(100);

}
catch (Exception e) {

    System.out.println(e);

}

list.get(0);