public static void setApplicationLook() {
    Class aClass = classLoader.loadClass("com.apple.eawt.Application");
    Method getApplication = aClass.getMethod("getApplication", null);
    Object application = getApplication.invoke(null);
    Method setDockIconImage = aClass.getMethod("setDockIconImage", Image.class);
    setDockIconImage.invoke(application, Globals.iconImage);
}