public int  getDefaultSimmm(Context context) {

    Object tm = context.getSystemService(Context.TELEPHONY_SERVICE);
    Method method_getDefaultSim;
    int defaultSimm = -1;
    try {
        method_getDefaultSim = tm.getClass().getDeclaredMethod("getDefaultSim");
        method_getDefaultSim.setAccessible(true);
        defaultSimm = (Integer) method_getDefaultSim.invoke(tm);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    Method method_getSmsDefaultSim;
    int smsDefaultSim = -1;
    try {
        method_getSmsDefaultSim = tm.getClass().getDeclaredMethod("getSmsDefaultSim");
        smsDefaultSim = (Integer) method_getSmsDefaultSim.invoke(tm);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return smsDefaultSim;
    }