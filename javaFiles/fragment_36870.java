...
    /* Define Header Information for the Table */
    for (int i = columnStart; i <= areaColumn; i++)
    {
        CTTableColumn column = columns.addNewTableColumn();
        column.setName(multi[0][i-1]);
        column.setId(i + 1);
        column.setTotalsRowFunction(org.openxmlformats.schemas.spreadsheetml.x2006.main.STTotalsRowFunction.SUM);
    }
...