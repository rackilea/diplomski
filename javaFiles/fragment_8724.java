// Parent functionality in here
public static abstract class Base<T extends Base<T>> {}

// This can be empty, or have just constructors if necessary
public static class Simple extends Base<Parent> {}

// Child functionality in here
public static class Extended extends Base<Extended> {}