private File createFile(final String szFileName) throws IOException {
    final File oFile = FileUtils.getFile(szFileName);        
    FileUtils.touch(oFile);

    return oFile;
}