public class ExcelResourceStream extends AbstractResourceStream {

    private ByteArrayInputStream inputStream;

    @Override
    public String getContentType() {
        return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    }

    @Override
    public Bytes length() {
        return Bytes.bytes(inputStream.available());
    }

    @Override
    public InputStream getInputStream() throws ResourceStreamNotFoundException {
        if (inputStream == null) {
            SomeExport export = new SomeExport();
            try {
                byte[] byteArray = ((ByteArrayOutputStream)export.getOutputStream()).toByteArray();
                inputStream = new ByteArrayInputStream(byteArray);
            } catch (IOException ioe) {
                // STUB
            }
        }

        return inputStream;
    }

    @Override
    public void close() throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
    }
}