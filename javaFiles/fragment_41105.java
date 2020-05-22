List<Column> columns = new ArrayList<Column>();
List<AxisValue> axisValues = new ArrayList<AxisValue>();

for (int i = 0; i < listVisitor.size(); ++i) {
    String label = listVisitor.get(i).getDate().toString();
    axisValues.add(new AxisValue(i).setLabel(label);

    values = new ArrayList<SubcolumnValue>();

    Column column = new Column(values);
    columns.add(column);

    // ...
 }

data = new ColumnChartData(columns);

if (hasAxes) {
    Axis axisX = new Axis(axisValues);
    // ...
    columnData.setAxisXBottom(axisX);
}