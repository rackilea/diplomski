interface ItemRequestConverter<IR extends ItemRequest>{}
interface ItemRequest{}
interface ItemRequestConverterFactory 
{
    public <IR extends ItemRequest> ItemRequestConverter<IR> newInstance(Class<IR> itemRequestClass);
}
class CreatePartRequestConverter<IR extends ItemRequest> implements ItemRequestConverter<IR>
{
}

class DefaultItemRequestConverterFactory implements ItemRequestConverterFactory 
{

    @Override
    public <IR extends ItemRequest> ItemRequestConverter<IR> newInstance(Class<IR> itemRequestClass) 
    {
        // Does not make sense: Comparing ItemRequest class with something
        // that is probably an implementation of ItemRequestConverter
        if (itemRequestClass.equals(CreatePartRequestConverter.class))
        {
            return new CreatePartRequestConverter<IR>();
        }
        return null;
    }
}