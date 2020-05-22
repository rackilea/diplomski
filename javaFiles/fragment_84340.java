DriverInfo aDriver = new DriverInfo(driver, null);
if(registeredDrivers.contains(aDriver)) {
    if (isDriverAllowed(driver, Reflection.getCallerClass())) {
        DriverInfo di = registeredDrivers.get(registeredDrivers.indexOf(aDriver));
        // If a DriverAction was specified, Call it to notify the
        // driver that it has been deregistered
        if(di.action() != null) {
           di.action().deregister();
        }
        registeredDrivers.remove(aDriver);
    } else {
        // If the caller does not have permission to load the driver then
        // throw a SecurityException.
        throw new SecurityException();
    }