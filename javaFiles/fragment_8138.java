String state = Environment.getExternalStorageState();
    if (state.equals(Environment.MEDIA_MOUNTED)) {
        // Storage is available and writeable - ALL GOOD  
    } else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
        // Storage is only readable - RUH ROH
    } else {
        // Storage is neither readable nor writeable - ABORT    
    }