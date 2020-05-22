public interface ISomeInterface
{
    default Integer callMe()
    {
        Integer result = finishObject();
        result = result + 1;

        return result;
    }

    // classes will need an instance of the object to implement this
    Integer finishObject(); 

    ...
}