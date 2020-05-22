public class LetterFactory implements ILetterFactory {
  @Inject Provider<A> aProvider;
  @Inject Provider<B> bProvider;

  @Override public Letter get(String which) {
    if (A.NAME.equals(which)) {
      return aProvider.get();
    } else if (B.NAME.equals(which)) {
      return bProvider.get();
    } else {
      throw new IllegalArgumentException("Letter does not exist");
    }
  }
}