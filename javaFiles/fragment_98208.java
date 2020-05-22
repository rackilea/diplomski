import "google/protobuf/descriptor.proto";

option java_outer_classname = "MyProto";
// By default, the "outer classname" is based on the proto file name.
// I'm declaring it explicitly here because I use it in the example
// code below.  Note that even if you use the java_multiple_files
// option, you will need to use the outer classname in order to
// reference the extension since it is not declared in a class.

extend google.protobuf.EnumValueOptions {
  optional string car_name = 50000;
  // Be sure to read the docs about choosing the number here.
}

enum CarModel {
  NOMODEL = 0 [(car_name) = "NOMODEL"];
  X = 1 [(car_name) = "X"];
  XS = 2 [(car_name) = "XS"];
  XSI = 3 [(car_name) = "XS-I"];
  XSI2 = 4 [(car_name) = "XS-I.2"];
}