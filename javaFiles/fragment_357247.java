try {
    Class clazz = Class.forName("Wizard");
    Field myMeshsettingsField = clazz.getDeclaredField("myMeshsettings");
    myMeshsettingsField.setAccessible(true);
    Object myMeshsettings = myMeshsettingsField.get();
    Method getmeshsize = myMeshsettings.getClass().getMethod("getmeshsize");
    double meshsize = (Double)getmeshsize.invoke(null);
} catch (ClassNotFoundException e) {
    System.out.println("wizard is unavailable");
}