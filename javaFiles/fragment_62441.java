TableLayout tableLayout = new TableLayout();
table.setLayout(tableLayout);

...
... don't call column.setWidth replace with:
tableLayout.addColumnData(new ColumnWeightData(nnn));