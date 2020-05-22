java.sql.Date dbSqlDateLastRecord = result.getDate("date");

//Convert java.sql.Date to LocaDate
LocalDate dateDB = dbSqlDateLastRecord.toLocalDate();

LocalDate dateSS = LocalDate.now();