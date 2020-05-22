public <T> ArrayList<T> getData(T similar) {
    if (similar.getClass().equals(Human.class)) {
        return (ArrayList<T>) new ArrayList<Human>();
    }

    if (similar.getClass().equals(Animal.class)) {
        return (ArrayList<T>) new ArrayList<Animal>();
    }

    return null;
}