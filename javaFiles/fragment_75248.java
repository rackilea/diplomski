public class JacksonColor {

    static class Foo {
        private Color color = new Color(0xcc, 0xcc, 0xcc);

        public Color getColor() { return color;}

        @Override
        public String toString() {
            return "Foo{" + "color=" + color + '}';
        }
    }

    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE)
    public static abstract class ColorMixIn extends Color {

        public ColorMixIn(
                @JsonProperty("red") int red,
                @JsonProperty("green") int green,
                @JsonProperty("blue") int blue) {
            super(red, green, blue);
        }
        @JsonProperty("red") public abstract int getRed();
        @JsonProperty("green") public abstract int getGreen();
        @JsonProperty("blue") public abstract int getBlue();
    }

    public static void main(String[] args) throws IOException {
        final SimpleModule module = new SimpleModule();
        module.setMixInAnnotation(Color.class, ColorMixIn.class);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        final Foo foo = new Foo();
        final String json = mapper.writeValueAsString(foo);
        System.out.println(json);
        System.out.println(mapper.readValue(json, Foo.class));
    }
}