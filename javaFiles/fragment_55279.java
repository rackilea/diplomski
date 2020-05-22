File dir = Environment
    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
File[] files = dir.listFiles();

for (File file : files) {
    if (file.getName().startsWith("data")) {
        // it's a match, call your function
    }
}