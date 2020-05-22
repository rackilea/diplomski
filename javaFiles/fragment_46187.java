try {
  verify(mEditor).apply();
} catch (MockitoAssertionError mae) {
  // apply was not called. Let's verify commit instead.
  verify(mEditor).commit();
}