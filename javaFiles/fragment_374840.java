TextColumnBuilder<String> itemBulletsCol = col.column(
    "", COLUMN_NAME_BULLET_LIST, type.stringType()
).setStyle(....
        .setFirstLineIndent(-10)
        .setPadding(10)
);