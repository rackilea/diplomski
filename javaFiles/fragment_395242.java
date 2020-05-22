List allColumns = table.getColumns(true);
forEach {
   if (column.getModelIndex() == modelIndex) {
        return column;
   }
return null;