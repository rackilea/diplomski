public class FormationFactory
{
    private final Map<Class<? extends Shape>, FormationBuilder> builders
            = new HashMap<Class<? extends Shape>, FormationBuilder>();

    public <T extends Shape> void register(
            Class<T> shapeType, FormationBuilder builder);
    {
        builders.put(shapeType, builder);
    }

    public Formation getFormation(Shape shape)
    {
        return builders.get(shape.getClass()).build(shape);
    }
}