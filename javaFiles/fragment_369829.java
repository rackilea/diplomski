public <T extends TorCircuit> T createCircuit(Class<T> torCircClass, boolean blocking) {
    T circ;
    try {
        circ = torCircClass.getDeclaredConstructor(TorSocket.class).newInstance(this);
    } catch (InstantiationException  | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
        throw new RuntimeException(e);
    }
    circ. ...
    return circ;
}