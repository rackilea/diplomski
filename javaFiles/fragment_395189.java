String state = Environment.getExternalStorageState();
 if (Environment.MEDIA_MOUNTED.equals(state)) {
        // Can read and write the media

    } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
        // Can only read the media

    } else {
        // Can't read or write
    }