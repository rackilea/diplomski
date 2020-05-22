Field<Integer> coalesce = DSL.coalesce(TABLE.COLUMN, 0);

for (Record record : DSL.using(configuration)
       .select(TABLE.A, TABLE.B, TABLE.C, coalesce)
       .from(TABLE)
       .where(condition)
       .orderBy(TABLE.A.asc(), coalesce.asc()))
    System.out.println(record.get(coalesce));