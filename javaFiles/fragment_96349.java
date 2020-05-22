private Collection<MyObject> aggregate(List<MyObject> objects) {
    Map<String, MyObject> map = new HashMap<String, MyObject>();
    for (MyObject current : objects) {
       String key = String.format("%s:%s", current.gender, current.state);
       MyObject aggregated = map.get(key);
       if (aggregated == null) {
           aggregated = new MyObject();
           aggregated.gender = current.gender;
           aggregated.state = current.state;
           map.put(key, aggregated);
       }
       aggregated.quantity += current.quantity;
       aggregated.salary += current.salary;
    }
    return map.values();
}