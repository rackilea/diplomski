int counter = 1;
String queryString= "WHERE (employeeId IN ( ";
Iterator<Long> it = getEmployeeSet().iterator();
while (it.hasNext()) {
  if (counter % 999 == 0)
     queryString= queryString.substring(0, queryString.length() - 1) + " ) or
     employeeId IN ( '" + it.next()+ "',";
  else
     queryString+= "'" + it.next() + "',";
     counter++;
}
append(queryString.substring(0, queryString.length() - 1) + " )) ");