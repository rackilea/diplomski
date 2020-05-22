LinkedList<String> yourListWithName = new LinkedList<String>();
//Fill your list

ListIterator<String> listIterator = yourListWithName.listIterator();

String previous = null;

while(listIterator.hasNext()) {

    if(listIterator.hasPrevious())
    {

        previous = listIterator.previous();
        listIterator.next();
    }

    String current = listIterator.next();

    if(current.equals(yourReceivedName))
        //Your algorithm
}