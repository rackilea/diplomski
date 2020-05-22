}
public class ImageFilter {
    //store in a list which can store any type of Uniform
    List<Uniform<?>> uniformList = new ArrayList<Uniform<?>>();

    //store in a map which can store any type of uniform and uses type as key
    Map<Class<?>, Uniform<?>> uniformMap = new HashMap<>();

    //Type parameter 'T' on the method itself
    public <T> void addProperty(Uniform<T> property, T type) {
        uniformList.add(property);
        uniformMap.put(type.getClass(), property);
    }
}
{
    //sample usage
    new ImageFilter().addProperty(new Uniform<>(), "test");
    new ImageFilter().addProperty(new Uniform<>(), new Double(2.0));
}