private void saveCallLog(final int callRecordID){
    // key here is callRecordID
    sharedPrefCallLog = getSharedPreferences("CallLogPref", Context.MODE_PRIVATE);
    editorCallLogPref = sharedPrefCallLog.edit();
    editorCallLogPref.putString("name_"+ callRecordID, Name);
    editorCallLogPref.putString("num_"+ callRecordID, Number);
    editorCallLogPref.putString("city_"+ callRecordID,City);
    editorCallLogPref.apply();
}