class test {
    private Object[] objects;
    private int size;

    public test() {
        objects = new Object[10];
        size = 0;
    }

    public void push(Object o) {
        if (objects.length == size) {
            throw new RuntimeException("This wouldn't happen if I didn't have to reinvent the wheel");
        }
        objects[size] = o;
        size++;
    }

    public Object pop() {
        size--;
        Object o = objects[size];
        objects[size] = null;
        return o;
    }
}