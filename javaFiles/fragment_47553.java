public static boolean getLastModified() throws IOException{
    File dir = new File("C:\\temp\\lot_of_files\\logs");

    File[] files = dir.listFiles();
    if (files.length == 0) {
        throw new IOException("No files to monitor in the dir");
    }

    Date modifiedDate = null;
    File lastModifiedFile = files[0];
    for (int i = 1; i < files.length; i++) {
       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
            modifiedDate = new Date(files[i].lastModified());
       }
    }
    Date currentDate = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(currentDate);
    cal.add(Calendar.HOUR, -24);
    Date alertDate = cal.getTime();

    if (modifiedDate != null && modifiedDate.before(alertDate)){
        return true;
    } else {
        return false;
    }
}