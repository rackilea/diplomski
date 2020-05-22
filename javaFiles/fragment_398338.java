ctx.execute(
  "WITH "
+ "  new_a(id) AS ({0}), "
+ "  new_b(id) AS ({1}) "
+ "{2}",

  // {0}
  insertInto(TABLE_A)
  .columns(TABLE_A.VAL)
  .values(aVal)
  .returning(TABLE_A.ID),

  // {1}
  insertInto(TABLE_B)
  .columns(TABLE_B.VAL)
  .values(bVal)
  .returning(TABLE_B.ID),

  // {2}
  insertInto(TABLE_BRIDGE)
  .columns(TABLE_BRIDGE.TABLE_A_ID, TABLE_BRIDGE.TABLE_B_ID)
  .select(
      select(field("new_a.id", Long.class), field("new_b.id", Long.class))
      .from("new_a, new_b")
   )
);