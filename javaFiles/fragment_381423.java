syntax = "proto3";
import "google/protobuf/wrappers.proto";

message Foo {
    .google.protobuf.Int32Value foo = 1;
}