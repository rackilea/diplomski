long insert(@NonNull final Table<?> table,
            @NonNull final Collection<Field<?>> columns,
            @NonNull final Collection<Object> values) {
    dslContext
          .insertInto(table)
          .columns(columns)
          .values(values)
          .execute();
    return dslContext.lastID().longValue();
}