while (s.hasNext()) {
    String line = s.nextLine();
    String items [] = line.split(";");

    Date date = dateFormat.parse(items[0]);
    if(!employees.containsKey(date)) {
        employees.put(date, new HashSet<>());
    }
    Employee employee = new Employee();
    // Put src_ip, src_port, dst_ip ... etc into the variable 'employee'
    employees.get(date).add(employee);
}