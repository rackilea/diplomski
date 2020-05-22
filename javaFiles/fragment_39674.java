import "google/protobuf/descriptor.proto";

extend google.protobuf.EnumValueOptions {
  DogMessage.DogBreed dogBreed = 51234;
}

message DogMessage {
  enum DogBreed {
    GERMAN_SHEPHERD = 0;
    FRENCH_BULLDOG  = 1;
  }

  enum  Dog {
    MAX     = 0 [(dogBreed) = GERMAN_SHEPHERD];
    SCOOTER = 1 [(dogBreed) = FRENCH_BULLDOG];
  }
}