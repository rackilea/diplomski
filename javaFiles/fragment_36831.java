public class MyClass {
    // Often fields are final to create an immutable class
    private final String fieldA;

    // Private constructor using Builder to set inner fields
    // To create MyClass you have to use Builder
    private MyClass(Builder builder) {
        // Setting fields from builder
        this.a = builder.getFieldA();
    }

    public static class Builder {
       // Fields on Builder are not final
       private String fieldA;

       //Getters and setters

       // Method to set field of builder
       public Builder setFieldA(String a) {
          this.a = a;
          return this;   // Returning this to chain setters
       }

    ...
        // Method to instantiate MyClass
        public MyClass build() {
           return new MyClass(this);
        }
    }
}

// Calling it as follow
MyClass a = new MyClass.Builder()
                .setFieldA("value")
                .setFieldB("value")
                .build();