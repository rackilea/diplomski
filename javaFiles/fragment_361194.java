public static class ZipUtils {

    private final List<File> fileList;

    private List<String> paths;

    public ZipUtils() {
        fileList = new ArrayList<>();
        paths = new ArrayList<>(25);
    }

    public void zipIt(File sourceFile, File zipFile) {
        if (sourceFile.isDirectory()) {
            byte[] buffer = new byte[1024];
            FileOutputStream fos = null;
            ZipOutputStream zos = null;

            try {

                String sourcePath = sourceFile.getPath();
                generateFileList(sourceFile);

                fos = new FileOutputStream(zipFile);
                zos = new ZipOutputStream(fos);

                System.out.println("Output to Zip : " + zipFile);
                FileInputStream in = null;

                for (File file : this.fileList) {
                    String path = file.getParent().trim();
                    path = path.substring(sourcePath.length());

                    if (path.startsWith(File.separator)) {
                        path = path.substring(1);
                    }

                    if (path.length() > 0) {
                        if (!paths.contains(path)) {
                            paths.add(path);
                            ZipEntry ze = new ZipEntry(path + "/");
                            zos.putNextEntry(ze);
                            zos.closeEntry();
                        }
                        path += "/";
                    }

                    String entryName = path + file.getName();
                    System.out.println("File Added : " + entryName);
                    ZipEntry ze = new ZipEntry(entryName);

                    zos.putNextEntry(ze);
                    try {
                        in = new FileInputStream(file);
                        int len;
                        while ((len = in.read(buffer)) > 0) {
                            zos.write(buffer, 0, len);
                        }
                    } finally {
                        in.close();
                    }
                }

                zos.closeEntry();
                System.out.println("Folder successfully compressed");

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void generateFileList(File node) {

        // add file only
        if (node.isFile()) {
            fileList.add(node);

        }

        if (node.isDirectory()) {
            File[] subNote = node.listFiles();
            for (File filename : subNote) {
                generateFileList(filename);
            }
        }
    }
}