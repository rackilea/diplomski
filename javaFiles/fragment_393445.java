Map<Integer, Person> people = new HashMap<Integer, Person>();
ResultSet resultSet = [some query on PERSON];

while(resultSet.next()) {
   Person p = [make a person]
   people.add(p.id, p);
}

resultSet = [some query on TELEPHONE];
while(resultSet.next()) {
   people.get(resultSet.getInt("P_ID")).telNos.add(resultSet.getInt("TEL_NO"));
}