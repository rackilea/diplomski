public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK)    {

        switch (requestCode) {
            case ACTION_REQUEST_GALLERY:
                Uri galleryImageUri = data.getData();
                try{
                    Log.e("Image Path Gallery" , getPath(getActivity() , galleryImageUri));
                    selectedImagePath = getPath(getActivity() , galleryImageUri);
                } catch (Exception ex){
                    ex.printStackTrace();
                    Log.e("Image Path Gallery" , galleryImageUri.getPath());
                    selectedImagePath = galleryImageUri.getPath();
                }

                break;

            case ACTION_REQUEST_CAMERA:
                // Uri cameraImageUri = initialURI;
                Uri cameraImageUri = data.getData();
                Log.e("Image Path Camera" , getPath(cameraImageUri));
                selectedImagePath = getPath(cameraImageUri);
                break;
        }

    }
}