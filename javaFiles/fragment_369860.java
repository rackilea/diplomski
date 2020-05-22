// here i can return the concrete type that was passed in
public <T extends Animal> Map<T, String> getNamesMap(ArrayList<T> list) {
    Map<T, String> names = new HashMap<T, String>();
    for (T animal : list) {
        names.put(animal, animal.getName()); // I assume there is a getName() method
    }
    return names;
}

// here i have to use general Animal
public Map<Animal, String> getNamesMap(ArrayList<? extends Animal> list) {
    Map<Animal, String> names = new HashMap<Animal, String>();
    for (Animal animal : list) {
        names.put(animal, animal.getName()); // I assume there is a getName() method
    }
    return names;
}