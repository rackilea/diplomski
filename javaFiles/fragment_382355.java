Map<String, String> map = new HashMap<>();
Map<String, Integer> mapInt = new HashMap<>();

for (Field field : ClassA.class.getDeclaredFields()) {
    field.setAccessible(true);
    if (field.getType().equals(String.class)){
        map.put(field.getName(), (String) field.get(object));
    } else if (field.getType().equals(int.class)) {
        mapInt.put(field.getName(), (Integer) field.get(object));
    }
}