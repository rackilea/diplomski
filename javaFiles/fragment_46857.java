imageOne = getImageBitmap(imageStrg);

@Override
protected void onPostExecute(String result) {
    // Write the result (document title) to the textview
    super.onPostExecute(result);

    // Update the textview with results
    if (result == null) {

        txtVwDocTitleValue.setText("Nothing to report...");
    } else {
        txtVwDocTitleValue.setText(result);
        txtVwDocURLValue.setText(imageURL);

        // Set the views image
        imgVwManga1.setImageBitmap(imageOne);
    }
    // Destroy the progress bar
    stopProgressDialog();
}