Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {
                    KEY_URL
                    }, 
                    "title=?", 
                    title,
                    null, 
                    null, 
                    null, 
                    null);