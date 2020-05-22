public abstract class AWriter<T extends A> {
  public static void AWritingMethod(T arg) {}
}

public class BWriter extends AWriter<B> {
  public static void BWritingMethod(B arg) {
    AWriter.AWritingMethod(arg)
  }
}

public class CWriter extends AWriter<C> {
  public static void CWritingMethod(C arg) {
    AWriter.AWritingMethod(arg)
  }
}