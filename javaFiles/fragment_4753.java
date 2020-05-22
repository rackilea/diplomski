package right.name;
option java_outer_classname = "RightProtos";
message Foo {
    required SomeType id = 1;
}
enum SomeType {
    cool_name = 1;
    another_cool_name = 2;
    different = 3;
}