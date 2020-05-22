public static List<List<Employee>> groupList(List<Employee> empList) {
    Map<String, List<Employee>> map = new HashMap<>();

    for(Employee e : empList) {
        String designation = e.getDesignation();
        List<Employee> list = map.get(designation);
        if (list == null) {
            list = new ArrayList<>();
            map.put(designation, list);
        }
        list.add(e);
    }

    return new ArrayList<>(map.values());
}