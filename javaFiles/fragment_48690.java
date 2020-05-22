class BaseModel<T> {
    int count;

    public T setCount(int value) {
        this.count = value;
        return (T) this;
    }
}

class FooModel extends BaseModel<FooModel> {
    int age;

    public FooModel setAge(int value) {
        this.age = value;
        return this;
    }
}