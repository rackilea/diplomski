public class FolderResource extends WebResource {

    private File folder;

    public FolderResource(File folder) {
        this.folder = folder;
    }

    @Override
    public IResourceStream getResourceStream() {
        String fileName = getParameters().getString("file");
        File file = new File(folder, fileName);
        return new FileResourceStream(file);
    }
}