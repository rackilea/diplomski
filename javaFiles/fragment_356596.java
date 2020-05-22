public static void main(String[] args) {
    // Both examples now compile
    Parent p;
    p = new App().new ChildBuilder()
        .withName("Test")
        .withNickName("Test1")
        .build();
    p = new App().new ChildBuilder()
        .withNickName("Test1")
        .withName("Test")
        .build();

}

class Parent {
    public Parent(String name) {}
}

class Child extends Parent {
    public Child(String name, String nickName) { super(name); }
}

abstract class AbstractParentBuilder<T extends AbstractParentBuilder<T>> {
    protected String name;
    protected AbstractParentBuilder() {}

    public Parent build() { return new Parent(name); }

    @SuppressWarnings("unchecked")
    public T withName(String name) {
        this.name = name; 
        return (T) this; 
    }
}

class ParentBuilder extends AbstractParentBuilder<ParentBuilder> {}

abstract class AbstractChildBuilder<T extends AbstractChildBuilder<T>> extends AbstractParentBuilder<T> {
    protected String nickName;
    protected AbstractChildBuilder() {}        

    public Child build() { return new Child(name, nickName); }

    @SuppressWarnings("unchecked")
    public T withNickName(String nickName) { 
        this.nickName = nickName; 
        return (T) this; 
    }
}

class ChildBuilder extends AbstractChildBuilder<ChildBuilder> {}