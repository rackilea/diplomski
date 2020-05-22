// Linux may as well resort to pure Java hackery, as there's no Linux native way of doing it
// right anyway.

String[] browsers = {"sensible-browser", "xdg-open", "google-chrome", "chromium", "firefox", "iceweasel", "mozilla", "opera", "konqueror", "nautilus", "galeon", "netscape"};

for ( final String browser : browsers ) {
    try {
        LWJGLUtil.execPrivileged(new String[] { browser, url });
        return true;
    } catch (Exception e) {
        // Ignore
        e.printStackTrace(System.err);
    }
}