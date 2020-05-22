static class ParentBuilder<B extends ParentBuilder<B>> {
    public B age(Integer age) {
        this.age = age;
        return (B) this;
    }
}

static class ChildBuilder extends Parent.ParentBuilder<ChildBuilder> {
    private Integer height;

    public ChildBuilder height(Integer height) {
        this.height = height;
        return this;
    }

    public Child build() {
        return new Child(this);
    }
}