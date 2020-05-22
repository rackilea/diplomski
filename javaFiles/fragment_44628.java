int i = 0;
  do  {
   Log.d("DatabaseHelper", "i: " + i + ", dataset_name: " + myCursor.getString(0));
        datasetInfos[i] = new DatasetInfo();
        datasetInfos[i].dataset_name = myCursor.getString(0);
        datasetInfos[i].type = myCursor.getInt(1);
        ++i;
} while (myCursor.moveToNext());