public void uploadFile() {


    new Thread() {

        @Override
        public void run() {

            //
            // Uploads the given file, when the upload is complete
            // the onFinish() method is called and the file is passed
            // back so I can update the RecyclerView
            //
            for (int i = 0; i < selectedIndicies.size(); i++) {
                // Get the i-th selected item
                Upload_Item_Model selectedItem = adapter.getFilteredData().get(selectedIndicies.get(i));

                // Get the file associated with the i-th selected item
                SaveFile file = getFileWithFilename(token, selectedItem.getTitle(), UploadActivity.this);
                FileUploader.upload(file, new FileUploader.FileUploadListener() {

                    @Override
                    public void onFinish(SaveFile file) {

                        // Loop through all items in RecyclerView
                        for (Upload_Item_Model item : adapter.getFilteredData()) { // this is line 471 where the crash happens

                            //
                            // If the RecyclerView item has the same name
                            // as the returned file, then it is
                            // the file I just uploaded
                            //

                            if (item.getTitle().equals(file.getFilename())) {
                                runOnUiThread(() -> {

                                    // Removes the item from the adapter
                                    adapter.removeItem(item);
                                    adapter.notifyDataSetChanged();
                                });

                            }
                        }
                    }
                });

            }
        }
    }.start();
}