//My GATE resources are in the "/gate" folder of the JAR
URI url = getClass().getResource("/gate").toURI();

File gateHome;
if (url.isOpaque()) {
    logger.info("Unpacking GATE resources from JAR");
    String tempDirectoryPath = FileUtils.getTempDirectoryPath();
    String gateResource = "gate";
    //Delete any existing temporary directory
    FileUtils.deleteDirectory(new File(FilenameUtils.concat(tempDirectoryPath, gateResource)));
    String gateHomePath = extractDirectoryFromClasspathJAR(getClass(), gateResource, tempDirectoryPath);
    gateHome = new File(gateHomePath);

} else {
    gateHome = new File(url);
}
Gate.setGateHome(gateHome);