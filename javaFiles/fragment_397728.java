for (File file : fileList) {
    if (!file.isDirectory()) { // we only zip files, not directories
        addToZip(directoryToZip, file,zos);
    }
}
//here close zos
zos.close();