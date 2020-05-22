new AsyncTask<Void, Void, Boolean>() {
    Exception error;

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
             // do work
             return true;
        } catch (Exception e) {
            error = e;

            return false;
        } 
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result) {
            Toast.makeText(ctx, "Success!",
                Toast.LENGTH_SHORT).show();
         } else {
            if (error != null) {
                Toast.makeText(ctx, error.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }