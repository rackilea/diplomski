File[] files = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString()).
    listFiles(new FileFilter() {
        public boolean accept(File pathname) {
            String name = pathname.getName();
            return pathname.isFile() && name.toLowerCase().startsWith("capture") && name.toLowerCase().endsWith(".jpeg");
        }
});

int fileCount = files.length();

fos = new FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + 
    "capture" + fileCount + ".jpeg");