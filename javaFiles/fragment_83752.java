package sub.optimal;
option java_outer_classname = "MyResponseProtos";
import "Alternative.proto";
import "Index.proto";
message MyResponse {
    repeated AlternativeV1 alternativeV1 = 1;
    required IndexV1 indexV1 = 2;
}