private static final String INSERT_SQL = "insert into patients(patient_id, first_name, last_name, middle_name, birth_dt) values(?, ?, ?, ?, ?)";

DateFormat inputFormatter = new SimpleDateFormat("dd/MM/yy");
Date dob = inputFormatter.parse(strDOB);
PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
// bind your values here.
int numRowsAffected = ps.executeUpdate();