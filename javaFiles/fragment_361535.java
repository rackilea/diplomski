public enum Feature {
     A("Type1", 0), // index 0 in bit string
     B("Type2", 1), // index 1 in bit String
     C("Type3", 2), // index 2 in bit String
     ...
     Z("TypeZ", 100); // index 100 in bit String

     private final String featureName;
     private final int index;
}