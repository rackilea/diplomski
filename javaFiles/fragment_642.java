long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
    long startTimeMillis = (startTime.getTime() % MILLIS_PER_DAY)/1000;
    long stopTimeMillis = (endTime.getTime() % MILLIS_PER_DAY)/1000;
    entityManager
            .createNativeQuery(
                    "select * from foo where to_number(to_char(date_time, 'sssss')) between ?1 and ?2", Foo.class)
            .setParameter(1, startTimeMillis)
            .setParameter(2, stopTimeMillis).getResultList();