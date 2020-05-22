public abstract class AWriter<T extends A> {
  public void AWritingMethod(T arg) {}
}

public class BWriter extends AWriter<B> {
  public static void BWritingMethod(B arg) {
    new BWriter().AWritingMethod(arg);
  }
}

public class CWriter extends AWriter<C> {
  public static void CWritingMethod(C arg) {
    new CWriter().AWritingMethod(arg);
  }
}