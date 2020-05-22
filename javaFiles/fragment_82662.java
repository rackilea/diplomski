public boolean addPerson(Person x){
    boolean found = false;

    for(int i = 0; i < people.length; i++){   // you're filling the array in this loop
        if (people[i] == null){
            people[i] = x;
            found = true;
        }
    }
    return found;
}