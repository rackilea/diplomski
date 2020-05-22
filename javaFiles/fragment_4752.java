package wrong.name;
option java_outer_classname = "WrongProtos";
message Foo {
    required SomeType id = 1;
}
enum SomeType {
    cool_name = 1;
    another_cool_name = 2;
    native = 3;
}