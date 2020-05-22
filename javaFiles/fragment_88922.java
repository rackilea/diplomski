public myAsyn extends AsyncTask<Void,Void,Void>
{
   @Override
        protected String doInBackground(Void... params) {
         data = pullSchedule(data);
               return null;     
        }

        @Override
        protected void onPostExecute(String result) {
           updateUI(data,arrayPosition);
        }
}