List<ImageFileInfo> imageFileList = new ArrayList<ImageFileInfo>();
while(rs.next()){
    ImageFileInfo info = new ImageFileInfo();
    info..setName(rs.getString("imagename").trim());
    ...
    imageFileList.add(info);
}