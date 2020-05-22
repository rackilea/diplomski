@Builder
public class Dragon {
    private Dimensions dimensions;
    private String name;

    public static class DragonBuilder {

        private Dimensions.DimensionsBuilder innerBuilder = 
                new Dimensions.DimensionsBuilder(this);

        // If a method of the same name exists, Lombok does not generate
        // another one even if the parameters differ.
        // In this way, users cannot set their own dimensions object.
        public Dimensions.DimensionsBuilder dimensions() {
            return innerBuilder;
        }

        // Customize build() so that your innerBuilder is used to create 
        // the Dimensions instance.
        public Dragon build() {
            return new Dragon(innerBuilder.build(), name);
        }
    }
}