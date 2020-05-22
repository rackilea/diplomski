loadRelatedName(position + 1);    

void loadRelatedName(int cid) 
{
     sql = " SELECT * FROM table WHERE cid = " + cid;
     Cursor c = db.select(sql);
     if (c ! null)
        while(c.moveToNext()) {
            Syso("Related Name : " + c.getString[2]);
     }
}