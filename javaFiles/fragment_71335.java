long insert(@NonNull final Table<?> table,
            @NonNull final Collection<Field<?>> columns,
            @NonNull final Collection<Object> values) {
    return dslContext
          .insertInto(table)
          .columns(columns)
          .values(values)
          .returning(table.field("ID")) // Replace with your field name case
          .fetchOne()
          .into(long.class);
}