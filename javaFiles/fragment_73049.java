public int insert(Competition competition) {
    // All local variables must be final because the lambdas will be executed at a undefined time
    final int id = competition.getId();
    final String name = competition.getName();

    final String[] dates = competition.getDates();
    final String dateValueStr = String.join(", ", Collections.nCopies(dates.length, "(?, ?)"));

    // Execute Updates
    int updatedRows1 = jdbcTemplate.update(conn -> {
        PreparedStatement ps = conn.prepareStatement(INSERT_STMT);
        ps.setInt(1, id);
        ps.setString(2, name);
        return ps;
    });

    if (updatedRows1 < 1)
    {
        // Something went wrong
        return -1;
    }

    int updatedRows2 = jdbcTemplate.update(conn -> {
        PreparedStatement ps = conn.prepareStatement(INSERT_DATES + dateValueStr);

        int idx = 1;
        for (String date : dates)
        {
            ps.setString(idx, date); // date_time
            idx++;
            ps.setInt(idx, competitionID); // competition_id
            idx++;
        }

        return ps;
    });

    if (updatedRows2 < 1)
    {
        // Something went wrong
        // Rollback the first insert, idk how its made
        return -1;
    }

    return updatedRows1 + updatedRows2;
}