public Bundle getCollectionDetails(){

        SQLiteDatabase db = this.getReadableDatabase();
        Bundle cursorData = new Bundle();
        String selectQuery = "SELECT * FROM " + TABLE_COLLECTION;

        Cursor cursor = db.rawQuery(selectQuery, null);
        int no_of_rows=cursor.getCount();           //count the no of rows in the database
        String[] cust_id=new String[row_count]; 
        String[] method=new String[row_count] ;
        int[] amount=new int[row_count]    
        int[] cheq_no=new int[row_count]
        int i=0;

        if(cursor.moveToFirst()){
            cust_id[i]= cursor.getString(cursor.getColumnIndex(KEY_CUSTOMER_ID));
            if(cursor.getInt(cursor.getColumnIndex(KEY_CHEQ_NO)) == 0){
                method[i]="Cash";
            }else{
                mehod[i]="Cheque";
            }
            amount[i]= cursor.getInt(cursor.getColumnIndex(KEY_AMOUNT));
            cheq_no[i]= cursor.getInt(cursor.getColumnIndex(KEY_CHEQ_NO));
             i++;
        }
        cursorData.putStringArray("cust_id",cust_id);
         cursorData.putStringArray("method",method);
        cursorData.putIntArray("amount",amount);
         cursorData.putIntArray("cheq_no",cheq_no);
        return cursorData;
    }