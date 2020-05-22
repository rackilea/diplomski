long count = jdbi.withHandle(handle -> {
        return handle.createQuery("select count(*) from attendance_jobs where tsrange(start_date, end_date) && tsrange(:start_date, :end_date)")
            .bind("start_date", start_date)
            .bind("end_date", end_date)
            .mapTo(Long.class)
                .findOnly();
    });