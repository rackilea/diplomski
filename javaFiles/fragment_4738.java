@Override
            public void onClick(DialogInterface dialogInterface, int i) {

                StringBuilder stringBuilder = new StringBuilder();

                String[] projection = {
                        LogEntry._ID,
                        LogEntry.COLUMN_LOG_DATE,
                        LogEntry.COLUMN_LOG_DESTINATION,
                        LogEntry.COLUMN_LOG_PURPOSE,
                        LogEntry.COLUMN_LOG_MILEAGE};


                Cursor cursor = getContentResolver().query(
                        LogEntry.CONTENT_URI,
                        projection,
                        null,
                        null,
                        null);

                //if the cursor isn't null we will essentially iterate over rows and then columns
                //to form a table of data as per database.
                if (cursor != null) {

                    //more to the first row
                    cursor.moveToFirst();

                    //iterate over rows
                    for (int index = 0; index < cursor.getCount(); index++) {

                        //iterate over the columns
                        for(int j = 0; j < cursor.getColumnNames().length; j++){

                            //append the column value to the string builder and delimit by a pipe symbol
                            stringBuilder.append(cursor.getString(j) + " | ");
                        }
                        //add a new line carriage return
                        stringBuilder.append("\n");

                        //move to the next row
                        cursor.moveToNext();
                    }
                    //close the cursor
                    cursor.close();
                }



                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipent@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Logs for " + ;
                emailIntent.putExtra(Intent.EXTRA_TEXT, stringBuilder.toString()); //id + "\n" + date + "\n" + destination + "\n" + purpose + "\n" + mileage);
                startActivity(Intent.createChooser(emailIntent, "Select App"));