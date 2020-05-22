if (Cursor.moveToFirst()) {
                do {
                    keyname.add(Cursor.getString(Cursor.getColumnIndex("keyname")));
                    key_description.add(Cursor.getString(Cursor.getColumnIndex("key_description")));

                } while (Cursor.moveToNext());
            }
            Cursor.close();