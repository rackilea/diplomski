public static void main(String[] args) throws Exception {
    Portal portal = new Portal();
    Object list = portal.getClass().getDeclaredMethod("getActionList", null).invoke(portal, null);
    Object action = list.getClass().getDeclaredMethod("get", new Class[] { int.class }).invoke(list, 0);
    action.getClass().getDeclaredMethod("action", null).invoke(action, null);
}