private void isFileDownloaded(String fileName) {
    if (fileName != null && !TextUtils.isEmpty(fileName)) {
        File file = new File(Environment.getExternalStorageDirectory().toString() + File.separator + Environment.DIRECTORY_DOWNLOADS,"/"+fileName);
        if (file.exists()) {
            return;
        } else {
            // write here code for download new file
        }
    }
}