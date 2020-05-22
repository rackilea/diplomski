class Boo {
    private String s = "Default";

    Boo(String s) {
        this.s = s;
    }

    Boo() {
    }

    protected String getString() {
        return s;
    }
}