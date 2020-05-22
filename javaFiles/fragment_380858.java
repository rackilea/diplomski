public class OODetector {
  public static boolean isOOOnClassPath() {
    try {
      OODetector.class.getClassLoader().loadClass("org.... class name here ...");
      return true;
    } catch (Throwable t) {
      return false;
    }
  } 
}