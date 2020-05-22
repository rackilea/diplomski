void foo() {
    Random r; // r never gets initialized
}
...
class Foo {
    Random r; // gets initialized to null
}