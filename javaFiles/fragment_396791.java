public static List<Dog> cloneList(List<Dog> dogList) {
    List<Dog> clonedList = new ArrayList<Dog>(dogList.size());
    for (Dog dog : dogList) {
        clonedList.add(new Dog(dog));
    }
    return clonedList;
}