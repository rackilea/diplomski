interface CommonInterface {
    enum Setter {
        Bar,
        Foo;
    }

    void setBar(String str);
    void setFoo(String str);

    default void set(Setter set, String value) {
        switch(set) {
        case Bar:
            setBar(value);
            break;
        case Foo:
            setFoo(value);
            break;
        default: // Do nothing
        }
    }
}