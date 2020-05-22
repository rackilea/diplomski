ListIterator<List<Point>> it = listOfList.listIterator();
while (it.hasNext()) {
    List<Point> list = it.next();
    ...
    it.set(listTemp);
}