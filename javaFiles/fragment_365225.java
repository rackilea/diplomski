Iterator<String> iterator = firstName.iterator();
Iterator<String> iterator1 = lastName.iterator();

while(iterator.hasNext() && iterator1.hasNext()){
    String FirstName = iterator.next();
    String LastName = iterator1.next();
    // add FirstName and LastName to the new list here
}