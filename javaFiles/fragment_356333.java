if (cursor != null) 
{
    try {
       while (cursor.moveToNext()) 
       {
        i = 0;
            // System.out.println(" =======> From DBConnect, Header => "+cursor.getString(1));
       }
    } catch (Exception e) {
       Log.d("DB_SELECT_BUSINESS_EXCEPTION", "" + e.getMessage());
    } finally {
       cursor.close();
    }
}