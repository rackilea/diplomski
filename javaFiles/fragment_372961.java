private void uploadImageToS3(String filePath){
        final File newImageFile = new File(filePath);
        showProgressDialog(TAG, getString(R.string.loading_please_wait));

        //For auth route
        BasicAWSCredentials credentials = new BasicAWSCredentials(CognitoManager.getS3ClientID(), CognitoManager.getS3ClientSecret());

        AmazonS3Client s3 = new AmazonS3Client(credentials);
        TransferUtility transferUtility = new TransferUtility(s3, this);
        TransferObserver observer = transferUtility.upload(CognitoManager.getS3BucketName(), newImageFile.getName(), newImageFile);
        observer.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {
            if(state.compareTo(TransferState.COMPLETED) == 0){
                String imgURLOfUploadComplete = "https://s3.amazonaws.com/" + CognitoManager.getS3BucketName() + "/" + newImageFile.getName();
                hideProgressDialog(TAG);
                Intent intent = new Intent();
                intent.putExtra(Globals.INTENT_KEYS.KEY_IMAGE_URL, imgURLOfUploadComplete);
                setResult(Activity.RESULT_OK, intent);
                if(newImageFile.exists()){
                    newImageFile.delete();

                }
                finish();

            }

        }
        @Override
        public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
            if(bytesTotal != 0) {
                //For viewing progress
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
            }
        }
        @Override
        public void onError(int id, Exception ex) {
            A35Log.e(TAG, getString(R.string.error_uploading_s3_part1) + id + getString(R.string.error_uploading_s3_part2) + ex.getMessage());
            hideProgressDialog(TAG);
            showDialogMessage(getString(error), getString(R.string.error_failed_create_image_alert_id) + error);

        }

    });

}