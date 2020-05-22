int no_of_rows=dbHandler.getCollectionCount();
String[] cust_id=new String[row_count]; String[] method=new String[row_count] ; int[] amount=new int[row_count]
int[] cheq_no=new int[row_count] int i=0; Bundle data = dbHandler.getCollectionDetails(); cust_id=data.getStringArray("cust_id"); //simililarily retrive for others

for(int i = 0; i < dbHandler.getCollectionCount(); i++){ Bundle data = dbHandler.getCollectionDetails();

    JSONObject jObject = new JSONObject();
    try {
        jObject.put("cust_id", cust_id[i]);
        json.put(jObject);
    } catch (JSONException e) {
    // TODO Auto-generated catch block
        e.printStackTrace();
    }                       
}