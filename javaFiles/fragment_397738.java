public class Option<T>
{
    public final T value;
    public final boolean present;

    private Option(T value, boolean present)
    {
        this.value = value;
        this.present = present;
    }

    public static <T> Option<T> some(T value)
    {
        return new Option<T>(value, true);
    }

    @SuppressWarnings("unchecked")
    public static <T> Option<T> none()
    {
        return none;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final Option none = new Option(null, false);
}