List<Object[]> rows = criteria.list();
List<Employee> result = new ArrayList<Employee>(rows.size());
for (Object[] row : rows) {
    Employee e = new Employee();
    e.setId((Long) row[0]);
    e.setName((String) row[1]);
    Address address = new Address();
    address.setCity((String) row[2]);
    e.setAddress(address);
    result.add(e);
}