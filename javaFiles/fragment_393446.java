Map<Integer, Person> people = new HashMap<Integer, Person>();
while(resultSet.next()) {
    int pId = resultSet.getInt("P_ID");
    if (!people.containsKey(pId)) {
       people.add(pId, [build a new person]);
    }
    people.get(pId).telNos.add(resultSet.getInt("TEL_NO"));
}