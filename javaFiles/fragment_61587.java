if (!mediaStorageDir.exists()) {                        
                    if (!mediaStorageDir.mkdirs()) {
                        Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                                + IMAGE_DIRECTORY_NAME + " directory");
                    }
                }