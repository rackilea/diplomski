public class FileReference extends PhantomReference<CachedImage> {
  private final File _file;

  public FileReference(CachedImage img, ReferenceQueue<CachedImage> q, File f) {
    super(img, q);
    _file = f;
  }

  public File getFile() {
    _file;
  }
}