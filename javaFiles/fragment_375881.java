public static List<clsNameID> assetHelperTypes(){
    Log.e("Asset Helper Types:", "Started");
    clsNameID AssetDetails = null;
    List<clsNameID> mHelperNames = new ArrayList<clsNameID>();
    File dbfile = new File(Global.currentDBfull); 

    SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
    Cursor f = db.rawQuery("select * from assetobservationtypes", null);  
    Log.e("Asset Helper Types:", "Cursor run");
        if(f.getCount() != 0) {
         f.moveToFirst();
            while(!f.isAfterLast()) {
                          //add this line....
                          AssetDetails     = new clsNameID();
                Log.e("Asset Helper Types:", "Finding Items");

                AssetDetails.ID = f.getString(f.getColumnIndex("AssetObsID"));
                AssetDetails.Name = f.getString(f.getColumnIndex("Observation"));

                mHelperNames.add(AssetDetails);
                Log.e("Asset Helper Types:", "Added Items");
            }
        }
    f.close();

    return mHelperNames;
}