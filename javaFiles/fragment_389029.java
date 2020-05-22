Cursor csr = dbhlpr.getWritableDatabase().query(DatabaseHelper.APP_ROLE_TABLE_NAME,null,null,null,null,null,null);
        String logdata;
        while (csr.moveToNext()) {
            logdata = "Data in Row=" + csr.getPosition();
            for (int i=0; i < csr.getColumnCount(); i++) {
                logdata = logdata +
                        "\n\t" + "Column Name=" + csr.getColumnName(i) +
                        " Value=" + csr.getString(i);
            }
            Log.d("ROWINFO",logdata);
        }
        csr.close();