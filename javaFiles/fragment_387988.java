interface ActivityCommon {
    void doSomething();
}

class ThisActivity implements ActivityCommon {
    public void doSomething() {
        System.out.println("This is ThisActivity's doSomething");
    }
}

class ThatActivity implements ActivityCommon {
    public void doSomething() {
        System.out.println("This is ThatActivity's doSomething");
    }
}

class Strawberry {
    foo(ActivityCommon common) {
        common.doSomething();
    }
}