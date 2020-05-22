LocalDateTime dateTimeNow = LocalDateTime.now(ZoneId.of("Europe/Rome"));
    LocalDate dateToday = dateTimeNow.toLocalDate();
    LocalTime timeNow = dateTimeNow.toLocalTime();
    PreparedStatement ps 
            = con.prepareStatement("insert into Table1(Data, Hour) values(?, ?)");
    ps.setObject(1, dateToday);
    ps.setObject(2, timeNow);
    ps.executeUpdate();