File fileTTS = new File(destFileName);

if (fileTTS.exists()) {
    Log.d(TAG, "successfully created fileTTS");
}
else {
    Log.d(TAG, "failed while creating fileTTS");
}