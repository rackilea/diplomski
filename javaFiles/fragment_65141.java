@Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Shows Progress Bar Dialog and then call doInBackground
    }

    // Download  File from Internet
    @Override
    protected String doInBackground(String... f_url) {

        try {
        //make server call and store file in local
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }
        return LOCAL_FILE_NAME;
    }


    @Override
    protected void onPostExecute(String local_file_url) {
        // read local_file_url

    }
}