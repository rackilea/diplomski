public Number resolveServerStatus(Object serverStatus)
    throws IllegalAccessException, IllegalArgumentException,
        InvocationTargetException {

    Method[] serverStatusMethods = serverStatus.getClass().getMethods();
    for (Method serverStatusMethod : serverStatusMethods) {
        if (serverStatusMethod.getName().equalsIgnoreCase("get" + field)) {
            serverStatusMethod.setAccessible(true);
            return (Number) serverStatusMethod.invoke(serverStatus);
        }
    }
}