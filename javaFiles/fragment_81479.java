public List<Employee> getAllEmployees() {
    DBObject query = new BasicDBObject();
    DBCursor cursor = employeeCollection.find(query);
    System.out.println("cursor.count : " + cursor.count());
    List<Employee> list = new ArrayList<Employee>();
    while (cursor.hasNext()) { 
             DBObject emp = cursor.next();
             Employee employee = new Employee();
             employee.setId((long) emp.get("id"));
             employee.setLocationId((long) emp.get("locationId"));
             BasicDBList positions = (BasicDBList) emp.get("position");
             for (Object position : positions) {
                Position pos = new Position();
                pos.setLatitude((double) ((DBObject) position).get("latitude"));
                pos.setLongitude((double) ((DBObject) position).get("longitude"));
                pos.setTime((String) ((DBObject) position).get("time"));
                employee.getPosition().add(pos);
            }
             list.add(employee);
    }
    return list;
}