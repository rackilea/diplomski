public void push(E e) {
    if (e == null) {
        throw new NullPointerException("Can't push a null element");
    }

    addElement(e);
    System.out.println("The element pushed is " + e);
}