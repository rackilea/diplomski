// Don't let Lombok create a builder() method, so users cannot 
// instantiate builders on their own.
@Builder(builderMethodName = "")
public class Dimensions {
    private double height;
    private double length;

    public static class DimensionsBuilder {
        private Dragon.DragonBuilder parentBuilder;

        // The only constructor takes a reference to the containing builder.
        DimensionsBuilder(Dragon.DragonBuilder parentBuilder) {
            this.parentBuilder = parentBuilder;
        }

        // Provide a method that returns the containing builder.
        public Dragon.DragonBuilder back() {
            return parentBuilder;
        }

        // The build() method should not be called directly, so 
        // we make it package-private.
        Dimensions build() {
            return new Dimensions(height, length);
        }
    }
}