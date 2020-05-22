public void launchCamera(int id){

            switch (id) {
            case 0:
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                ((Activity)getParent()).startActivityForResult(cameraIntent, 1888);
                break;
            case 1: 
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                ((Activity)getParent()).startActivityForResult(intent, 2);
                break;
            default:
                break;
            }
        }