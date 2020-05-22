if (!hashMap.containsKey(locationId)) {
    List<Student> list = new ArrayList<Student>();
    list.add(student);

    hashMap.put(locationId, list);
} else {
    hashMap.get(locationId).add(student);
}