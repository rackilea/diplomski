Iterator<Integer> iterator = list.iterator();
while(iterator.hasNext()) {
    Integer integer = iterator.next();

    // ...check if you want to remove this one...

    iterator.remove();
}