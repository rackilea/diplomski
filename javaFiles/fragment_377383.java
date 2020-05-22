reportSomeoneButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Report a Driver")
                    .setMessage("License Plate #: ")
                    .setView(reportInput)
                    .setPositiveButton("Submit", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int i)
                        {
                            String licensePlate = String.valueOf(reportInput.getText());
                            SQLiteDatabase db = dbAssistant.getWritableDatabase();
                            ContentValues values = new ContentValues();
                            values.put(ReportDataSource.ReportSubmission.COL_TASK_TITLE, licensePlate + "\n" + currentDate);
                            db.insertWithOnConflict(ReportDataSource.ReportSubmission.TABLE,
                                    null, values, SQLiteDatabase.CONFLICT_REPLACE);
                            db.close();
                            refreshList();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();
            dialog.show();
            }



    });