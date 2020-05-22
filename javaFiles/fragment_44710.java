if (cursor != null)
        cursor.moveToFirst();

ShipmentStatusDao notification = new ShipmentStatusDao(cursor.getInt(0),
            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));

return notification;