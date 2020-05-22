static class Lookup<T2> {

    List<ValueObject<T2>> valueObjects = new ArrayList<>();
    List<String> valueNames = new ArrayList<>();

    ValueObject<T2> get(String name) {
        return valueObjects.get(valueNames.indexOf(name));
    }

    public void set(String name, T2 value) {
        get(name).setValue(value);
    }
}