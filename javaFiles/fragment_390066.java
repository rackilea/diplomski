ArrayList<String> studentdata = new ArrayList<String>();
studentdata.add(student.getString("nome"));
studentdata.add(student.getString("cognome"));
studentdata.add(student.getString("numero"));
studentdata.add(student.getString("email"));

result.add(studentdata);