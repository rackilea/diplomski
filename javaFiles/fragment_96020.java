while(input.hasNextLine()) {
    String name = input.nextLine();
    if(name.equals("-")) {
        continue;
    }
    if(personMap.containsKey(name)) {
        // find the people
        Person mother = personMap.get(input.nextLine());
        Person father = personMap.get(input.nextLine());
        Person kid = personMap.get(name);

        // link them up
        kid.setMother(mother);
        kid.setFather(father);
        mother.addKid(kid);
        father.addKid(kid);
    } else {
        personMap.put(name, new Person(name)); // create the people objects from the initial list
    }
}