File file = new File("C:\\dir");
    if (!file.exists()) {
        if (file.mkdir()) {
            // success
        } else {
            // failure
        }
    }