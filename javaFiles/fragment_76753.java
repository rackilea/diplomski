class FileZipOutputInterface implements ZipOutputInterface {

    File file;

    public FileZipOutputInterface(File file) {
        this.file = file;
    }

    public String getName() {
        return file.getAbstractName();
    }
    public InputStream getInputStream() {
        return new FileInputStream(file);
    }
}