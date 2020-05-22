result = getJdbcTemplate().update(sql, new Object[]{
        notification.value1(),
        notification.value2(),
        null, // <--
        notification.value4(),
        notification.value5(),
        notification.value6(),
        notification.value7(),
        notification.value8(),
        notification.value9()
        });