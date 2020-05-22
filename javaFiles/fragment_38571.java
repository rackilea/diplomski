enum SomeEnum {
    SONG,
    KLIP,
    KARAOKE
}

static class SomeClass {

    SomeEnum someEnum;

    public SomeClass(SomeEnum someEnum) {
        this.someEnum = someEnum;
    }

    public SomeEnum getSomeEnum() {
        return someEnum;
    }
}