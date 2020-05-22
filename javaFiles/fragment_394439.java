public final class StringToIntegerAdapter implements Function<String, Integer> {

    public static final StringToIntegerAdapter INSTANCE = new StringToIntegerAdapter();

    /** Private constructor forces everyone to use the singleton. */
    private StringToIntegerAdapter() {
    }

    @Override
    @Nullable
    public Integer apply(@Nullable final String str) {
        if (str == null) {
            return null;
        } else {
            return Integer.valueOf(str);
        }
    }
}