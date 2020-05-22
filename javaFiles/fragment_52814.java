class AAA<T extends AAA<T>> {
    public T withSomeAStuff() {
        return self();
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }
}

class BBB<T extends BBB<T>> extends AAA<T> {
    public T withSomeBStuff() {
        return self();
    }
}

class CCC extends BBB<CCC> {
    public CCC withSomeCStuff() {
        return this;
    }
}


public static void main(String[] args) {
    AAA<?> aaa = new AAA<>().withSomeAStuff();
    BBB<?> bbb = new BBB<>().withSomeAStuff().withSomeBStuff(); 
    CCC ccc = new CCC().withSomeAStuff().withSomeBStuff().withSomeCStuff();
}