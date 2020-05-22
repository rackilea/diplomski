private class GenericMessageListCreator {
    public <U, V extends GenericMessage<U>> List<U> getList(Class<V> clazz){
        return new ArrayList<U>();
    }
}

private class GenericMessage<T> {
    public GenericMessage(){};
    private T internalValue;

    public void setValue(T value)
    {
        this.internalValue = value;
    }

    public void echoValue() {
        System.out.println("I contain " + internalValue);
    }
}

private class StringMessage extends GenericMessage<String>{}
private class IntegerMessage extends GenericMessage<Integer>{}