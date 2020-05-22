option java_package = "sub.optimal";
option java_outer_classname = "MediatorMessage";

message MediatorMessageMsg{
    required double speed = 1;
    required double heading = 2;

    required string sender = 3;
}