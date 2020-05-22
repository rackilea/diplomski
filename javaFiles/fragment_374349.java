public FixGroupMgr getGroupMgr(String fixVersion)
    throws ClassNotFoundException, InstantiationException,
    IllegalAccessException {
    String versionIdent = fixVersion.replaceAll("[\",.]", "") + "Mgr";
    FixGroupMgr.cleanStaticData();
    /*
     * Class<?> c = ClassLoader.getSystemClassLoader().loadClass(
     * "com.globalforge.infix." + versionIdent);
     */
    Class<?> c =
        FixContextMgr.class.getClassLoader().loadClass(
            "com.globalforge.infix." + versionIdent);
    return (FixGroupMgr) c.newInstance();
}