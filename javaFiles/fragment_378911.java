openDB();
Cursor c = myDb.getSpalte();
List<Integer> valueList = new ArrayList<Integer>(c.getCount());

while (c.moveToNext()) {        
    valueList.add(c.getInt(0)); // assuming the first column is of type INT
}
c.close();
closeDB();

XYSeries series1 = new SimpleXYSeries(
                 valueList,
                 SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
                 "Series1");