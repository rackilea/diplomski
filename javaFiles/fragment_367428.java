private static final String a;

static {

    String value = null;
    try {
        value = fn();
    } catch (Exception e) {
    }
    a = value;

}