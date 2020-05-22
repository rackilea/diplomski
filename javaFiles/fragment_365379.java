ContentResolver contentResolver = getContentResolver();
        final Cursor cursor = contentResolver.query(CalendarContract.Calendars.CONTENT_URI,
                (new String[]{CalendarContract.Calendars._ID, CalendarContract.Calendars.CALENDAR_DISPLAY_NAME}), null, null, null);

        while (cursor.moveToNext()) {
            final String _id = cursor.getString(0);
            final String displayName = cursor.getString(1);


            int stringLength = displayName.length();
            String output = displayName.substring(stringLength - 10);
            //Log.d("Cursor", output);

            if (output.equals("ryerson.ca")) {
                //Log.d("Cursor", "true");
                calendarID = new String[]{_id};
            }

            Uri.Builder builder = CalendarContract.Instances.CONTENT_URI.buildUpon();

            Calendar beginTime = Calendar.getInstance();
            beginTime.set(2014, Calendar.SEPTEMBER, 2, 8, 0);
            long startMills = beginTime.getTimeInMillis();

            Calendar endTime = Calendar.getInstance();
            endTime.set(2014, Calendar.SEPTEMBER, 2, 20, 0);
            long endMills = endTime.getTimeInMillis();

            ContentUris.appendId(builder, startMills);
            ContentUris.appendId(builder, endMills);

            Cursor eventCursor = contentResolver.query(builder.build(), new String[]{CalendarContract.Instances.TITLE,
                            CalendarContract.Instances.BEGIN, CalendarContract.Instances.END, CalendarContract.Instances.DESCRIPTION},
                    CalendarContract.Instances.CALENDAR_ID + " = ?", calendarID, null);

            while (eventCursor.moveToNext()) {
                final String title = eventCursor.getString(0);
                final Date begin = new Date(eventCursor.getLong(1));
                final Date end = new Date(eventCursor.getLong(2));
                final String description = eventCursor.getString(3);

                Log.d("Cursor", "Title: " + title + "\tDescription: " + description + "\tBegin: " + begin + "\tEnd: " + end);
            }