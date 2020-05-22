abstract class Agent<A extends SomeClassThatSupportsAdd> {

    void callAgent();
    protected abstract A createNew();

    Agent() {
        A a = createNew();
        A.add();
    }
}