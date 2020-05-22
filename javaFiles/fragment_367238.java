private static final Object[] EMPTY_ELEMENTDATA = {};

....

public ArrayList() {
    super();
    this.elementData = EMPTY_ELEMENTDATA;  // This is 0 capacity!!!!
}