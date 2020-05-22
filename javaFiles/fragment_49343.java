public class LetterFactory implements ILetterFactory {
  @Inject Provider<T2> t2Provider;

  @Override public Letter get(String which) {
    if (A.NAME.equals(which)) {
      return new A(t2Provider.get());
    } else if (B.NAME.equals(which)) {
      return new B(t2Provider.get());
    } else {
      throw new IllegalArgumentException("Letter does not exist");
    }
  }
}