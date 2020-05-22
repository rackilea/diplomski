public void updateTable(String table, JsonObject data) {
    Table<?> table = PUBLIC.getTable(table);

    DSL.using(fooConfig)
       .update(table)
       .set(data.entrySet()
                .stream()
                .map(e -> new SimpleImmutableEntry(table.field(e.getKey()), e.getValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue)))
       .where(...) // Don't forget this! ;-)
       .execute();
}