public class FileTask implements Callable<Object> {

    private Path path;

    public FileTask(Path file) {
        this.path = file;
    }

    @Override
    public Object call() throws Exception {
        File file = path.toFile();
        if (file.exists()) {
            if (file.delete()) {
                //...
            }
        }
        return null;
    }

}