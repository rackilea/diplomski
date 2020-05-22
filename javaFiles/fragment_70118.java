public ArrayList<FileInfo> filesInMainFolder(string mainPath,
                                         ArrayList<FileInfo> files) {
    ArrayList<FileInfo> res = new ArrayList<FileInfo>();

    for (FileInfo info : files) {
        String url = info.getUrl().toString();
        // Get the path of the File for which we have file information
        url = url.substring(0, url.lastIndexOf('/'));

        // Is file in the main folder
        if (url.compareTo(mainPath) == 0 && info.isDirectory() == false) {

            res.add(info);
        }
    }
    return res;
}