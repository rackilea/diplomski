String nm = System.getProperty("java.awt.headless");

    if (nm == null) {
        /* No need to ask for DISPLAY when run in a browser */
        if (System.getProperty("javaplugin.version") != null) {
            headless = defaultHeadless = Boolean.FALSE;
        } else {
            String osName = System.getProperty("os.name");
            headless = defaultHeadless =
                Boolean.valueOf(("Linux".equals(osName) || "SunOS".equals(osName)) &&
                                (System.getenv("DISPLAY") == null));
        }
    } else if (nm.equals("true")) {
        headless = Boolean.TRUE;
    } else {
        headless = Boolean.FALSE;
    }