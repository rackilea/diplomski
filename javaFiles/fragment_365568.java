public static final String TEST_STRING;

static {
    TEST_STRING = getParameter("TEST", "default value",
            "The default is set, please ensure, that this is intended!");
}