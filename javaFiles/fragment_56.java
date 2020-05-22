public static void enableOSXFullscreen(Window window) {
    try {
        Class util = Class.forName("com.apple.eawt.FullScreenUtilities");
        Class params[] = new Class[]{Window.class, Boolean.TYPE};
        Method method = util.getMethod("setWindowCanFullScreen", params);
        method.invoke(util, window, true);
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
}

public static void requestOSXFullscreen(Window window) {
    try {
        Class appClass = Class.forName("com.apple.eawt.Application");
        Class params[] = new Class[]{};

        Method getApplication = appClass.getMethod("getApplication", params);
        Object application = getApplication.invoke(appClass);
        Method requestToggleFulLScreen = application.getClass().getMethod("requestToggleFullScreen", Window.class);

        requestToggleFulLScreen.invoke(application, window);
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        ex.printStackTrace();
    }
}