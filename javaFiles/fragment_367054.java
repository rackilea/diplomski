public class Decompress {
    private String zip;
    private String loc;

    public Decompress(String zipFile, String location) {
        zip = zipFile;
        loc = location;

        dirChecker();
    }

    private void dirChecker() {
        File f = new File(loc);

        if(!f.isDirectory()) {
            f.mkdirs();
        }
    }

    public void unzip() {
        try {
            ZipFile zipFile = new ZipFile(zip);
            List<FileHeader> fileHeaders = zipFile.getFileHeaders();
            for (FileHeader fileHeader : fileHeaders) {
                String fileName = fileHeader.getFileName();

                if (fileName.contains("\\")) {
                    fileName = fileName.replace("\\", "\\\\");
                    String[] Folders = fileName.split("\\\\");
                    StringBuilder newFilepath = new StringBuilder();
                    newFilepath.append(loc);
                    for (int i = 0; i < Folders.length - 1; i++) {
                        newFilepath.append(File.separator);
                        newFilepath.append(Folders[i]);
                    }
                    zipFile.extractFile(fileHeader, newFilepath.toString(), null, Folders[Folders.length - 1]);
                } else {
                    zipFile.extractFile(fileHeader, loc);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}