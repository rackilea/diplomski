Element toinsert = new Element("toinsert");

Iterator<Element> it = Dataelement.getChildren("myobject");
while (it.hasNext() && !"Propert6".equals(it.next().getAttribute("name"))) {
    // advance the iterator.
}
it.add(toinsert);