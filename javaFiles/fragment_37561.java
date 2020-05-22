Cursor dailycursor = db.rawQuery("SELECT avg(" + COLUMN_CURRENT_TEMPERATURES + "), " + COLUMN_TIME_STAMP + ", " +
            "CASE WHEN  strftime('%M', " + COLUMN_TIME_STAMP + ") < '30' " +
            "THEN strftime('%H', " + COLUMN_TIME_STAMP + ") " +
            "ELSE strftime('%H', " + COLUMN_TIME_STAMP + ", '+1 hours') END " +
            "FROM " + TABLE_WEATHER +  " "+
            "GROUP BY strftime('%H', " + COLUMN_TIME_STAMP + ", '+30 minutes')", null);