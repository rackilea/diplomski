ArrayList<ArrayList<String>> twoD= new ArrayList<ArrayList<String>>();

Cursor tSCursor = retrieveTS(tId);  
tSCursor.moveToFirst();

for (int i = 0; i < tSCursor.getCount(); i++) 
{
    stockId = tSCursor.getString(tSCursor.getColumnIndex("_id"));

    ArrayList<String> oneD = new ArrayList<String>(); 

    oneD.add(sId);

    oneD.addAll(retrieveSFinParams(sId));

    twoD.add(oneD);          

    tSCursor.moveToNext();
}