create.createTable(AUTHOR)
      .column(AUTHOR.ID, SQLDataType.INTEGER)
      .column(AUTHOR.FIRST_NAME, SQLDataType.VARCHAR.length(50))
      .column(AUTHOR_LAST_NAME, SQLDataType.VARCHAR.length(50))
      .constraints(
           constraint("PK_AUTHOR").primaryKey(AUTHOR.ID)
      )
      .execute();