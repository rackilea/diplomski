public class FileLoader implements Loader {
    public string load() throws NotFoundException {
        try{
          return readAll(file);
        } catch (Exception ex) {
          throw new NotFoundException(); //assuming it's file not found is not good
        }
    }
}