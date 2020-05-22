class Barney {

    void foo() { System.out.println("Barney says foo"); }

    class Fred extends Barney {
        @Override void foo() { Barney.this.foo(); }
    }

}