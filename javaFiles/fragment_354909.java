Field<Integer> views = min(MYTABLE.NUM_VIEWS).as("views");

Table<Record2<String, Integer>> nested = 
    table(create.select(MYTABLE.ID, min(views))
    .from(MYTABLE)
    .groupBy(MYTABLE.ID));

return create.select(sum(nested.field(views)))
    .from(nested)
    .fetchOne().value1().longValue();