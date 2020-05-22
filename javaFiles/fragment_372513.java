private class MyAsync extends AsyncTask<Void, Void, Void> {

        String firstname,lastname;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            table_layout.removeAllViews();

            PD = new ProgressDialog(MainActivity.this);
            PD.setTitle("Please Wait..");
            PD.setMessage("Loading...");
            PD.setCancelable(false);
            // get values here its UI thread 
            firstname = firstname_et.getText().toString();
            lastname = lastname_et.getText().toString();
            PD.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

           // **String firstname = firstname_et.getText().toString();
           // String lastname = lastname_et.getText().toString();**

            // inserting data
            sqlcon.open();
            sqlcon.insertData(firstname, lastname);
            // BuildTable();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            BuildTable();
            PD.dismiss();
        }
    }