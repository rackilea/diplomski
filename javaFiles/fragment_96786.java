for(ZipEntry zipEntry : java.util.Collections.list(zipFile.entries())){//lazislav
    String name = zipEntry.getName();
    int idx = name.lastIndexOf('/');
    if (idx>=0) name=name.substring(idx)
    if (name.length()==0) continue;

    File f = new File(targetDir, name);

}