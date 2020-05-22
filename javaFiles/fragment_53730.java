int itemID = -1;
            String item3 = ""; //<<<<<<<<<< ADDED
            while (data.moveToNext()){
                itemID = data.getInt(0);
                item3 = data.getString(data.getColumnIndex(DatabaseHelper.COL3)); //<<<<<<<<<< ADDED
            }