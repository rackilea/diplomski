public class UploadForm {

    private byte[] filedata;

    public UploadForm() {
    }

    public byte[] getFileData() {
        return filedata;
    }

    @FormParam("filedata")
    @PartType("application/octet-stream")
    public void setFileData(final byte[] filedata) {
        this.filedata = filedata;
    }


}