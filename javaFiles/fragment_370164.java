public class WebAssetsResource extends DirectoryServerResource {
    @Override
    public Representation handle() {
        Date desiredDate = ...; // I read this from File System
        getInfo().setModificationDate(desiredDate);
        return super.handle(); // Automatic logic will use desired date
    }
 }