// NOT HERE Person myPerson = new Person();
// ...

while(itr.hasNext()) {
    Object[] innerObj = (Object[]) itr.next();

    Person myPerson = new Person(); // HERE you create a new Person        
    myPerson.setName(String.valueOf(myArray[0]);
    myPerson.setLastName(String.valueOf(myArray[1]);
    myPerson.setNickName(String.valueOf(myArray[2]);

    personsList.add(myPerson); // add the new person to the list
}