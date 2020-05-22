Iterator<YourClass> iterator = list1.iterator();
while (iterator.hasNext()) {
    if (list2.contains(iterator.next().getId())) {
        iterator.remove();
    }
}