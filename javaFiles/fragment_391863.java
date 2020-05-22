private int merge(Person p1, Person p2) throws IllegalAccessException {
    int changes = 0;
    for(Field field: Person.class.getDeclaredFields()) {
        if(!field.getName().equals("id")) {
            field.setAccessible(true);
            Object originalField = field.get(p1);
            Object updatedField = field.get(p2);
            if(!originalField.equals(updatedField)) {
                field.set(p1, updatedField);
                changes++;
            }
        }
    }
    return changes;
}