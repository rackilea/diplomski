Foo.java:2: warning: [unchecked] Possible heap pollution from parameterized vararg type T
    static <T> void bar(final T... barArgs) {
                                   ^
  where T is a type-variable:
    T extends Object declared in method <T>bar(T...)
1 warning