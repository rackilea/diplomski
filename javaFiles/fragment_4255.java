interface ItemRequestConverter<IR extends ItemRequest>{}
interface ItemRequest{}
interface ItemRequestConverterFactory 
{
    public <IRC extends ItemRequestConverter<?>> ItemRequestConverter<?> newInstance(Class<IRC> itemRequestConverterClass);
}
class CreatePartRequestConverter implements ItemRequestConverter<ItemRequest>
{
}

class DefaultItemRequestConverterFactory implements ItemRequestConverterFactory 
{
    @Override
    public <IRC extends ItemRequestConverter<?>> ItemRequestConverter<?> newInstance(
        Class<IRC> itemRequestConverterClass)
    {
        if (itemRequestConverterClass.equals(CreatePartRequestConverter.class))
        {
            return new CreatePartRequestConverter();
        }
        return null;
    }
}