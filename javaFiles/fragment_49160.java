public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + Table_variables + "(id INTEGER PRIMARY KEY ,var1 text, var2 text, var3 text, var4 text, var5 text, var6 text, var7 text, var8 text, var9 text, var10 text, userid text )");
            db.execSQL("CREATE TABLE " + Table_values + "(id INTEGER PRIMARY KEY , val1 text, val2 text, val3 text, val4 text, val5 text, val6 text, val7 text, val8 text, val9 text, val10 text ,userid text )");
            db.execSQL("CREATE TABLE " + Table_ListId + "(id INTEGER PRIMARY KEY , val1 text, val2 text, val3 text, val4 text, val5 text, val6 text, val7 text, val8 text, val9 text, val10 text,userid text )");

            db.execSQL("CREATE TABLE " + Table_PaymentOptions + "(id INTEGER PRIMARY KEY, var1 text, var2 text, var3 text, var4 text, var5 text, var6 text, var7 text, var8 text , userid text, randomID text)");
            db.execSQL("CREATE TABLE " + Table_PaymentRemider + "(id INTEGER PRIMARY KEY, plc text, agencyname text,amountDue text, datedue text, reminderNotes text, reminderDate text, reminderTime text, toggleOption text, userid text, uniqueID text)");
        }