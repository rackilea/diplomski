// retrieves all the descriptions for the edittext fields
      public  Cursor getUserWord() 
        {
            return myDataBase.query(USER_WORD_TABLE, new String[] {
                    KEY_ID, 
                    KEY_CATEGORY,
                    KEY_SOURCE, KEY_TITLE, KEY_EDITWORD, KEY_USERWORD 
                    }, 
                    KEY_CATEGORY+ "=" + categories.categoryClick + " AND " + KEY_SOURCE+ "=" 
                    +source.sourceClick + " AND " + KEY_TITLE+ "=" + title.titleClick, 
                    null, null, null, KEY_ID);

        }