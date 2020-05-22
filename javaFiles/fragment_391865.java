if (cursor.moveToFirst()) {
            do {

                node temp = new node
                cursor.getInt(0),
                .........
                ADD_ARRAY_LIST.add(temp);

            } while (cursor.moveToNext());
        }