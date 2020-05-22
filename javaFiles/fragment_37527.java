pivotTable.addRowLabel(2);

        pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 5);
        pivotTable.addDataColumn(5, true);

        pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(1).setAxis(
                org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis.AXIS_COL);

        pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(1).addNewItems();
        pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(1).getItems().addNewItem().setT(
                org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType.DEFAULT);

        pivotTable.getCTPivotTableDefinition().addNewColFields().addNewField().setX(1);