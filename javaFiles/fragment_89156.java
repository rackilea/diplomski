private String[] allColumns = {
    MySQLiteHelper.COLUMN_level_1,
    MySQLiteHelper.COLUMN_level_2,
    MySQLiteHelper.COLUMN_level_3
};

String[] mydata = myobject.getData();

for(int i = 0; i < allColums.length(); i++){
    values.put(allColums[i], mydata[i]);
}