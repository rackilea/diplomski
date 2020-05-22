public class FileLoader implements Loader {
    public string load() throws NotFoundException {
        try{
          return readAll(file);
        } catch (FileNotFoundException ex) {
          throw new NotFoundException(); // OK to translate this specific exception
        } catch (IOException ex) {
          // catch other exception types we need to and that our interface does not
          // support and wrap in runtime exception
          throw new RuntimeException(ex);
        }
    }
}