DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
Date date = new Date();

String zipName = name+ "_" + dateFormat.format(date) + ".zip";
zippedFile = new File(archive, zipName);
if (zippedFile exists()) {
    zippedFile.delete();
}

ZipUtils zu = new ZipUtils();
zu.zipIt(dirToZip, zippedFile);