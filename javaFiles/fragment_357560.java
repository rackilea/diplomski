class Stack {
    protected Object[] elements = new Object[1];
}

class IntStack extends Stack {
    void push(Integer i) {
        // throws ClassCastException
        ((Integer[])elements)[0] = i;
    }
}