public static final class OneMoreClass {
        @Nullable String foo;

        void test() {
            if (isValid()) {
                System.out.println(foo.trim()); // no possible NPE warning
            }
        }

        boolean isValid() {
            return foo != null;
        }
    }