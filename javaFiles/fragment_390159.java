@Override
public boolean setAttribute(String name, Object value) {
    log.debug("setAttribute - name: {} value: {}", name, value);
    boolean result = true;
    ownerMessage.addEvent(Type.CLIENT_UPDATE_ATTRIBUTE, name, null);
    if (value == null && super.removeAttribute(name)) {
        // Setting a null value removes the attribute
        modified = true;
        syncEvents.add(new SharedObjectEvent(Type.CLIENT_DELETE_DATA, name, null));
        deleteStats.incrementAndGet();
    } else if (value != null && super.setAttribute(name, value)) {
        // only sync if the attribute changed
        modified = true;
        syncEvents.add(new SharedObjectEvent(Type.CLIENT_UPDATE_DATA, name, value));
        changeStats.incrementAndGet();
    } else {
        result = false;
    }
    notifyModified();
    return result;
}