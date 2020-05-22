FileResource fileResource = new FileResource("/some/path");
try {
    fileResource.open();
    fileResource.dostuff();
    //other logic
} catch (Exception e){
    fileResource.close();
    throw e;
}