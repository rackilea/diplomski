Cursor transactionlatestid = myDb.getLatestTransactionID(temp_position); 
if (transactionlatestid.getCount() == 0) { 
    temp_id = 1; 
} else {
    transactionlatestid.moveToFirst();
    temp_id = transactionlatestid.getInt(0); 
    temp += 1; 
} 
String transaction_id = String.valueOf(temp_id);