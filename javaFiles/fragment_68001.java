class Cell<E> {
    E value;

    Cell(E v)     { value = v; }
    E get()       { return value; }
    void set(E v) { value = v; }

    public static void main(String[] args) {
        Cell x = new Cell<String>("abc");
        System.out.println(x.value);  // OK, has type Object
        System.out.println(x.get());  // OK, has type Object
        x.set("def");                 // unchecked warning
    }
}