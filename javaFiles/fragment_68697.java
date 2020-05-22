LinkedHashMap<Integer, name> data = new LinkedHashMap<Integer, name>();
for (name item: list) {
    Integer age = Integer.valueOf(name.age);
    if (!data.containsKey(age)) {
        data.put(age, name);
    }
}
return data.values();