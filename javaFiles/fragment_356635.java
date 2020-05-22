public class System {
  public interface C extends Library {
    C INSTANCE = (C) Native.loadLibrary(
        (Platform.isWindows() ? "msvcrt" : "c"), C.class);

    public int system(String format);
  }

  public static void main(String[] args) {
    C.INSTANCE.system("vi");
  }
}