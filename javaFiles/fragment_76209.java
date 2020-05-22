@Nonnull
public static <T> T checkNotNull(@Nullable T reference) {
  if (reference == null) {
    throw new NullPointerException();
  }
  return reference;   
}