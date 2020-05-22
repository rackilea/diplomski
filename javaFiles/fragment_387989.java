class ActivityBase extends Activity { // Or whatever the base should be
    abstract void doSomething();
}

class ThisActivity extends ActivityBase {
    @Override
    public void doSomething() {
        System.out.println("This is ThisActivity's doSomething");
    }
}

class ThatActivity extends ActivityBase {
    @Override
    public void doSomething() {
        System.out.println("This is ThatActivity's doSomething");
    }
}

class Strawberry {
    foo(ActivityBase activity) {
        activity.doSomething();
    }
}