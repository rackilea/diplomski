FileConnection path = (FileConnection) Connector.open(
        "file:///SDCard/BlackBerry/documents/" + "status.zip",
        Connector.READ_WRITE);

if (!path.exists()) {
    path.create();
}
ZipOutputStream zinstream = new ZipOutputStream(path.openOutputStream());

// Adding Entries
FileConnection jsonfile = (FileConnection) Connector.open(
        "file:///SDCard/BlackBerry/documents/" + "status.json",
        Connector.READ_WRITE);
if (!jsonfile.exists()) {
    jsonfile.create();
}
int fileSize = (int) jsonfile.fileSize();
if (fileSize > -1) {
    InputStream input = jsonfile.openInputStream();
    byte[] data = new byte[1024];

    ZipEntry entry = new ZipEntry(jsonfile.getName());
    zinstream.putNextEntry(entry);

    int len;
    while ((len = input.read(data)) > 0) {
        zinstream.write(data, 0, len);
    }
    zinstream.closeEntry();
}
jsonfile.close();
zinstream.close();
path.close();