ListElement<E> item = head;
a.add(item);
while (item.getNext() != null){
     a.add(item.getNext());
     item = item.getNext();
}