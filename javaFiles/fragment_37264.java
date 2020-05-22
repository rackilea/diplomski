class class Dummy<T extends Blah> {
    Class<T> interfaceType;

    public void setInterfaceType(Class<T> input) {
        this.interfaceType = input;
    }
}