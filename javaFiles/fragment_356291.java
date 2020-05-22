SQLiteOpenHelper

 db.execSQL("CREATE TABLE "+MyDatabaseColums.USERINFOEntry.TABLE_NAME+" ("
                + MyDatabaseColums.USERINFOEntry.U_id+ " INTEGER , "
                + MyDatabaseColums.USERINFOEntry.mrname+ " TEXT, "
                + MyDatabaseColums.USERINFOEntry.meEmail+ " TEXT, "
"UNIQUE ( " +YOUR_id+") ON CONFLICT IGNORE"+");";