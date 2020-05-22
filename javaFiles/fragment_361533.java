public enum Feature {
     A("Type1", 1), // 1 << 0
     B("Type2", 2), // 1 << 1
     C("Type3", 4), // 1 << 2,
     ...
     F("Type6", 32); // 1 << 5

     private final String featureName;
     private final int value;

     // Constructor, getters/setters
}