public static boolean supportsPerAlphaPixel() {

    boolean support = false;

    try {

        Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
        support = true;

    } catch (Exception exp) {
    }

    return support;

}