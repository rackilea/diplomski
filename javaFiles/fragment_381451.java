Timestamp startDate = ...;
Timestamp endDate = ...;
String queryString = "select count(*) from attendance_jobs "
        + "where tsrange(start_date, end_date) && tsrange(:startDate, :endDate)";
long count = jdbi.withHandle(handle -> {
        return handle.createQuery(queryString)
            .bind("startDate", startDate)
            .bind("endDate", endDate)
            .mapTo(Long.class)
            .findOnly();
    });