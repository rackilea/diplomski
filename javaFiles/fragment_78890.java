String dropSql = "BEGIN EXECUTE IMMEDIATE 'DROP TABLE " + tmpTblName + "';" +
    " EXCEPTION" +
    " WHEN OTHERS THEN" +
    " IF SQLCODE!=-942 THEN" +
    " RAISE;" +
    " END IF;" +
    " END;";