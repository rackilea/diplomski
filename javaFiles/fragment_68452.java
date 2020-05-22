protected void onPostExecute(Boolean result) {

    if(result) {
        // he is now authenticated, dismiss dialog and continue in your app
        dialog.dismiss();
    } else {
        // nothing to do, until he succeed
    }    
}