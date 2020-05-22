try (DSLContext dsl = DSL.using(dbUrl)) {
    dsl.transaction((ctx) -> {
        dsl.createTable("TABLE1")
            .column("COL1", SQLiteDataType.CLOB)
            .column("COL2", SQLiteDataType.CLOB)
            .execute();

        dsl.insertInto(TABLE1)
            .columns(TABLE1.COL1, TABLE1.COL2)
            .values("ABB", null)
            .execute();

        Field<String> coalesce = DSL.coalesce(TABLE1.COL2, "");
        dsl.update(TABLE1).set(TABLE1.COL2, DSL.concat(coalesce, DSL.val(lines.toString())))
            .where(TABLE1.COL1.eq("ABB"))
            .execute();         

    });
    dsl.execute("VACUUM; ");
}