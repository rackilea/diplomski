package foo.bar;

class Outer {
    static class Document {
    }
}

...

Class<?> clazz = Class.forName("foo.bar.Outer$Document");