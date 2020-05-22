this.cursor = this.db.rawQuery("SELECT _id as _id , " + 
            DatabaseHelper.KEY_LAST_NAME + " , " + 
            DatabaseHelper.KEY_FIRST_NAME + " , " +
            "\"" + DatabaseHelper.KEY_SR_JR + "\" " + 
            "FROM " + DatabaseHelper.TABLE_NAME + 
            " WHERE " + DatabaseHelper.KEY_COLONY_NAME + " LIKE ? ORDER BY " 
            + DatabaseHelper.KEY_LAST_NAME, 
            new String[] { this.colonyName } );