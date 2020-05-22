/**
 * Search in modelMap for the last saved id from model passed and return the next one
 *
 * @param clazz Model to search the last id
 * @return The next id which can be saved in database for that model, 
 * {@code null} will be returned when this method is called by reflection
 */
public Integer getNextIdFromModel(Class<? extends RealmObject> clazz) {

    if (isValidMethodCall()) {
        AtomicInteger modelId = modelMap.get(clazz);
        if (modelId == null) {
            return 0;
        }
        return modelId.incrementAndGet();
    }
    return null;
}

/**
 * Utility method to validate if the method is called from reflection,
 * in this case is considered a not valid call otherwise is a valid call
 *
 * @return The boolean which define if the method call is valid or not
 */
private boolean isValidMethodCall() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    for (StackTraceElement stackTraceElement : stackTraceElements) {

        if (stackTraceElement.getMethodName().equals("newInstance")) {
            return false;
        }
    }
    return true;
}