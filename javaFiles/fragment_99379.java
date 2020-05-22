public void addCondition(View view) {
    SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
    Cursor f = db.rawQuery("select * from assetobservationtypes", null);  
    Log.e("Asset Helper Types:", "Cursor run");
    List<CharSequence> mHelperNames = new ArrayList<CharSequence>();
    final ArrayList<String> mHelperNamesID= new ArrayList<String>();  
    while(f.moveToNext()) {
        mHelperNames.add(f.getString(f.getColumnIndex("Observation")));
        mHelperNamesID.add(f.getString(f.getColumnIndex("AssetObsID")));
    }
    f.close();
    boolean[] checkedItems = new boolean[mHelperNames.size()];
    for (int  i = 0; i < checkedItems.length; i++) {
        checkedItems[i] = false;
    }
    for (int i = 0; i < mSelectedItems.size(); i++) {
        checkedItems[mSelectedItems.get(i).intValue()] = true;
    }
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("My Title").setMultiChoiceItems(mHelperNames.toArray(new CharSequence[mHelperNames.size()]), checkedItems,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which, boolean isChecked) {
                                if (isChecked) {

                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {

                                    mSelectedItems.remove(Integer
                                            .valueOf(which));
                                }
                            }
                        })

               .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {                      
                       txtCondition.setText("set");
                       txtCondition.setTextColor(Color.parseColor("#4c9226"));
                       count++;
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                       dialog.dismiss();
                   }
               });
        builder.show();
}