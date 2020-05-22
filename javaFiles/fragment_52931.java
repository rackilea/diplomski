@Override
public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource source) {
    return toIdentifier(
                "FK_" +
                source.getTableName().getText() + "_" +
                source.getReferencedTableName().getText() + "_" +
              addUnderscorestocolumns(source.getColumnNames()),
        source.getBuildingContext());
}