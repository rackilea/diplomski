public boolean equals(Object o){
    if(! (o instanceof Person)) return false; //a Person can't be equal to a non-person

    Person p = (Person) o;
    return personName == null && p.personName == null || personName.equals(p.personName);
}