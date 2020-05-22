int idColIndex = cursor2.getColumnIndex("_id");
int wordColIndex = cursor2.getColumnIndex("word");

// ...

Log.d(LOG_TAG,
            "_id = " + cursor2.getInt(idColIndex) +
                    ", word = " + cursor2.getString(wordColIndex));