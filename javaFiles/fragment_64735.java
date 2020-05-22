/**
 * @param window
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public static void enableOSXFullscreen(Window window) {
    Preconditions.checkNotNull(window);
    try {
        Class util = Class.forName("com.apple.eawt.FullScreenUtilities");
        Class params[] = new Class[]{Window.class, Boolean.TYPE};
        Method method = util.getMethod("setWindowCanFullScreen", params);
        method.invoke(util, window, true);
    } catch (ClassNotFoundException e1) {
    } catch (Exception e) {
        log.log(Level.WARNING, "OS X Fullscreen FAIL", e);
    }
}