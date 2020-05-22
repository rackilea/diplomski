Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.YEAR, 1990);
calendar.set(Calendar.DAY_OF_MONTH, 1);
calendar.set(Calendar.MONTH, 4); // Assuming you wanted May 1st

java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

// Ideally specify the columns here as well...
PreparedStatement prep = connection.prepareStatement(
    "insert into exampletable values (?,?)");
prep.setDate(1, date);
prep.setDate(2, date);