class StateInstanceDescription <T extends StateBase> implements Serializable { 

    transient private T stateBase;

    private Class<T> stateBaseClass; 

    public StateInstanceDescription(T base, Class<T> clazzBase) {
        this.stateBase = base;
        stateBaseClass = clazzBase;
    }

    public T getBase() {
        return stateBase;
    }

    public Class<T> getBaseClass() {
        return stateBaseClass;
    }
}