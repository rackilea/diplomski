abstract class Parent {
    protected abstract void send();
}
class ChildA extends Parent {
    protected void send() {
        Other.olmeth(this);
    }
}
class ChildB extends Parent {
    protected void send() {
        Other.olmeth(this);
    }
}
...
class ChildF extends Parent {
    protected void send() {
        Other.olmeth(this);
    }
}