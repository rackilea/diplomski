// you can modify the max value of a ProgressDialog, we modify it
// to prevent unnecessary rounding math.
// In the configuration set the max value of the ProgressDialog to an int with
pDialog.setMax(urls.length);

for (int i = 0; i < urls.length; i++) {
    // launch HTTP request and save the file
    //...
    // your code 
    //...

    //advance one step each completed download
    publishProgress();
}

/**
 * Updating progress bar
 */
protected void onProgressUpdate(Integer... progress) {
    pDialog.incrementProgressBy(1);
}