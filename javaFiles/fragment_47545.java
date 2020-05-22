public ArrayList<String> searchNumber(String name){
    ArrayList<String> result = new ArrayList<>(); // list incase of persons with the same name
    for (Person p : phonebook){ // iterate through the array
        if (p.getName().equals(name)){ // check if the current person's name is equal to anme
            result.add(p.getNumber()); // add the person's phone number
        }
    }
    return result ;
}