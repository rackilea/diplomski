public void setPressed(String keyName) {
    keyStates.put(keyName, true);
}

public void setReleased(String keyName) {
    keyStates.put(keyName, false);
}

public boolean isPressed(String keyName) {
    return keyStates.get(keyName);
}