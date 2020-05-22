public void setSecuredObjectsList(Object[] objects) {

    Map<String, String> rolesMap = new HashMap<String, String>();
    for (Object o:objects ) {
        setSecuredObject(o, rolesMap);
    }

    super.setMethodRolesMap(rolesMap);
}


public void setSecuredObject(Object object, Map<String, String> rolesMap) {
    Class<?> cls = ClassHelper.getRealClass(object);
    findRoles(cls, rolesMap);
    if (rolesMap.isEmpty()) {
        LOG.warning("The roles map is empty, the service object is not protected");
    } else if (LOG.isLoggable(Level.FINE)) {
        for (Map.Entry<String, String> entry : rolesMap.entrySet()) {
            LOG.fine("Method: " + entry.getKey() + ", roles: " + entry.getValue());
        }
    }
}