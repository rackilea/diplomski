UniqueKey<R> key = table.getPrimaryKey();
if (key != null) {
    List<TableField<R, ?>> fields = key.getFields();

    // Now create your condition from these fields
}