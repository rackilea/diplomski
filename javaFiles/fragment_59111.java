public abstract class Template<C extends Abstract>
{
    private Class<C> classOfC;

    public Template( Class<C> clazz ) {
        classOfC = clazz;
    }
}