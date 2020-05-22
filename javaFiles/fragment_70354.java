String SqlString = "select * from GetUser({0})";

    if (ipIdUser == null )
        SqlString = MessageFormat.format(SqlString, "NULL");
    else
        SqlString = MessageFormat.format(SqlString, ipIdUser);

    LOGGER.info("SqlSting =" + SqlString);

    return entityManager.createNativeQuery(SqlString, User.class)
            .getResultList();