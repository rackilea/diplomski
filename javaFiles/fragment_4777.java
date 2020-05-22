List<Table<?>> invalidTables = new ArrayList<>();

for (Table<?> table : MY_SCHEMA.getTables()) {
    try {
        create.selectFrom(table).where(Factory.falseCondition()).fetch();
    }

    // If table names / column names change, the above query would fail
    catch (DataAccessException e) {
        invalidTables.add(table);
    }
}