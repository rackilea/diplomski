public void run10TimesWhatsoever() {
    for(int i = 0; i < 10; ++i) {
        try {
          methodToCall();
        } catch (final FooException ignore) {
        }
    }
}