class DynastyPQ {
    final void run() {
        // code.
    }
    final void execute() {
        // code.
    }
    final void create() {
        // code.
    }

    void specific1() {}
    void specific2() {}
}

class CustomAPQ extends DynastyPQ {
    @Override
    void specific1() {
        // do stuff specific to CustomAPQ.
    }
    @Override
    void specific2() {
        // do stuff specific to CustomAPQ.
    }
}

class CustomBPQ extends DynastyPQ {
    @Override
    void specific1() {
        // do stuff specific to CustomBPQ.
    }
    @Override
    void specific2() {
        // do stuff specific to CustomBPQ.
    }
}