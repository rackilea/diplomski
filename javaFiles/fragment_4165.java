// ... previous code

String [][] arr = MobileTestClass_Methods.ExecuteMySQLQueryReturnsArrayWithColumnName(con, sqlQuery);
JSONArray json = new JSONArray ();
int totalrow =arr.length;
int totalcolumn =arr[0].length;

System.out.println("row: "+totalrow + " col: "+totalcolumn);

for(int i=1; i<totalrow; i++)
{
    JSONObject row = new JSONObject();
    for(int j=0; j<totalcolumn; j++)
    {
        String key = arr[0][j];
        String value = arr[i][j];
        row.put(key, value);
        System.out.println("Key: "+key + "  value: "+value);
    }
    json.put(row);
}

// ... rest of the code ...