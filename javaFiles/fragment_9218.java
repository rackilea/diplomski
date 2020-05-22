public void update( Person person )  {
     // Do whatever you want on that particular person
     ...

    // Update sub persons (assume subPersons maay not be null, only empty)
    for( Person subPerson: person.subPersons ) {
        update( subPerson );
    }
}