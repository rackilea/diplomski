List<Person> all = new ArrayList<Person>();
all.addAll(list1);
all.addAll(list2);

Map<String, Person> map = new HashMap<String, Person>();
for (Person p : all) {
    if (!map.containsKey(p.name) || map.get(p.name).num < p.num) {
        map.put(p.name, p);
    }
}
List<Person> merged = new ArrayList<Person>(map.values());