"SELECT * FROM (" +
    "SELECT to_char(logdate,'dd-MON-yy') AS \"Log Date\", " +
        "adj_login_time AS \"Log In Time\", " +
        "adj_logout_time AS \"Log Out Time\", " +
        "adj_lunch_in AS \"Lunch In\", " +
        "adj_lunch_out AS \"Lunch Out\", " +
        "round(logduration,2) AS \"Log Duration\" " +
    "FROM employee_time_log " +
    "WHERE employee_id_number = " +userInputIdNumber + " " +
    "ORDER BY logdate DESC" +
    ") WHERE ROWNUM <= 10";