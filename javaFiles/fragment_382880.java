public interface ISomeInterface
{
    default Integer callMe(Object someObject)
    {
        Integer result = someObject.finish();
        result = result + 1;

        return result;
    }

    ...
}