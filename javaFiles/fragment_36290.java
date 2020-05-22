private String getAppSpaceADFFolder() 
{
//  String mapsFolder = getFilesDir().getAbsolutePath() + File.separator + "Maps";
    String mapsFolder = "/sdcard/maps";
    File file = new File(mapsFolder);
    if (!file.exists()) {
        file.mkdirs();
    }
    return mapsFolder;
}