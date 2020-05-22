public class Parent {
    public Parent returnMyself() {
        return this;
    }
}

public class Child extends Parent {
    public Child returnMyself() {
        return this;
    }
}