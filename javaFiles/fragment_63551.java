List<Integer> newList = new ArrayList<Integer>();

Iterator<Integer> iterator = list.iterator();
while(iterator.hasNext()) {
    Integer integer = iterator.next();

    newList.add(integer);

    iterator.remove();
}