private class ActivationTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            SocketConnection connection = new SocketConnection();
            String token = "getActivation|" + params[0] + "|";
            return connection.EstablishConnection(token);
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s != null) {
                 Log.e("RESULT" , s);



            }
        }
    }