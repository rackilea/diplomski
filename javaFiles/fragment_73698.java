try{

   Cursor mCur = null;
    try{
     String sortOrder = Browser.BookmarkColumns.DATE + " ASC";
     mCur= context.getContentResolver().query(Browser.BOOKMARKS_URI, Browser.HISTORY_PROJECTION, null, null, sortOrder);

     mCur.moveToFirst();
     if (mCur.moveToFirst() && mCur.getCount() > 0) {
      while (mCur.isAfterLast() == false) {   
            String title = mCur.getString(Browser.HISTORY_PROJECTION_TITLE_INDEX);
            String url = mCur.getString(Browser.HISTORY_PROJECTION_URL_INDEX);
            long date = mCur.getLong(Browser.HISTORY_PROJECTION_DATE_INDEX);  
            mCur.moveToNext();
      }
         }else{
         mCur.close();
        }

    }catch(Exception e){

    }finally{
     mCur.close();
    }

  }catch(Exception e){

  }