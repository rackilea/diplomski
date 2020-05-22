Cursor c = newDB.rawQuery("select ID, Date, Hours from " + tableName + " where Date BETWEEN '" + startDateQueryDate + "' AND '" + endDateQueryDate + "' ORDER BY Date ASC", null);

            if (c != null ) {
                if  (c.moveToFirst()) {
                    do {
                        int tempId = c.getInt(c.getColumnIndex("ID"));
                        long tempUnixTime = c.getLong(c.getColumnIndex("Date"));

                        //convert tempUnixTime to Date
                        java.util.Date startDateDate = new java.util.Date(tempUnixTime);

                        //create SimpleDateFormat formatter
                        SimpleDateFormat formatter1;
                        formatter1 = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);

                        //convert Date to SimpleDateFormat and convert to String
                        String tempStringStartDate = formatter1.format(startDateDate);

                        int tempHours = c.getInt(c.getColumnIndex("Hours"));
                        results.add(+ tempId + "    Date: " + tempStringStartDate + "    Hours: " + tempHours);
                    }while (c.moveToNext());
                }
            }