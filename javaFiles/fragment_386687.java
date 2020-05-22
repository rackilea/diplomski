public void registerDestructionCallback(String name, Runnable callback, int scope) {
    if (logger.isWarnEnabled()) {
        logger.warn("Could not register destruction callback [" + callback + "] for attribute '" + name +
                        "' because FacesRequestAttributes does not support such callbacks");
    }
}