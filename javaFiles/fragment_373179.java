@Override
                public void onClick(View view) {
 queryText = (queryEditText.getText().toString());
                    Log.i(LogConstants.LOG, "Text value is " + queryText);
                    if (queryText.equals("")) {
                        Toast.makeText(context, "You did not enter a query", Toast.LENGTH_SHORT).show();
                    } else {
                        new SearchAsyncTask().execute();
                        }
                }