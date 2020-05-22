public static void main(String[] args) {

    Set<Foo> set = new HashSet<Foo>();
    set.add(new Foo("Hello"));

    for (Iterator<Foo> it = set.iterator(); it.hasNext(); ) {
        Foo f = it.next();
        if (f.equals(new Foo("Hello")))
            System.out.println("foo found");
    }
}

static class Foo {
    String string;
    Foo(String string) {
        this.string = string;
    }
    @Override
    public int hashCode() { 
        return string.hashCode(); 
    }
    @Override
    public boolean equals(Object obj) {
        return string.equals(((Foo) obj).string);
    }
}