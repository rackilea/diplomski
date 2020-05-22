@Override
protected void onActivityResult(int requestCode, int resultCode, 
Intent data) {
    if (requestCode == COLOR_PICKED_REQUEST) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {
            int color = data.getIntExtra("COLOR"); 
            mActionDialog.userPickedColor(color);
        }
    }
}