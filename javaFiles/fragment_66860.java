import static ResourceUtil.tr;

public String howBigIsTheFile(File f) {
  String name = f.getAbsolutePath();
  long length = f.length();
  return tr("The file %s is %d bytes long", name, length);
}