query = "SELECT first_name, last_name, email, salary FROM HR.Employees where rownum < 6";
rset = stmt.executeQuery(query);
List<HRPerson> returnHRdata = new ArrayList<HRPerson>();
while (rset.next()) {
   HRPerson person = new HRPerson();
   person.firstName = rset.getString("first_name");
   person.lastName  = rset.getString("last_name");
   person.email     = rset.getString("email");
   person.salary    = rset.getInt("salary");
   returnHRdata.add(person);
}