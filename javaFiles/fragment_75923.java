abstract class Animal {
    public final void walk() {
        // do stuff
        moreWalking();
    }

    protected void moreWalking() {

    }
}
class Person extends Animal {
    protected void moreWalking() {
        // do stuff
    }
}
class Dog extends Animal {
    // No need to implement moreWalking
}