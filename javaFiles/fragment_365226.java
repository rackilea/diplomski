Iterator<String> iterator = firstName.iterator();
Iterator<String> iterator1 = lastName.iterator();
List<String> newList = new ArrayList<String>();

while(iterator.hasNext() && iterator1.hasNext()){
    String FirstName = iterator.next();
    String LastName = iterator1.next();
    newList.add(FirstName + " " + LastName);
}