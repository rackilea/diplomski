public void breakGeneric(List list) {
    list.add("foo");
}
....
List<Long> myList = new ArrayList<>();
breakGeneric(myList);