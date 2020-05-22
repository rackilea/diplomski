interface ItemRequestConverter<IR extends ItemRequest>{}
interface ItemRequest{}
interface ItemRequestConverterFactory 
{
    public <IR extends ItemRequest> ItemRequestConverter<IR> 
        newInstance(Class<IR> itemRequestClass);
}

class CreatePartRequest implements ItemRequest {}
class CreatePartRequestConverter 
    implements ItemRequestConverter<CreatePartRequest> {}

class DefaultItemRequestConverterFactory implements ItemRequestConverterFactory 
{
    @Override
    public <IR extends ItemRequest> ItemRequestConverter<IR> newInstance(
            Class<IR> itemRequestClass)
    {
        if (itemRequestClass.equals(CreatePartRequest.class))
        {
            CreatePartRequestConverter result = new CreatePartRequestConverter();
            return (ItemRequestConverter<IR>) result;
        }
        return null;
    }
}

public class GenericFactoryTest
{
    public static void main(String[] args)
    {
        ItemRequestConverterFactory factory = null;
        ItemRequestConverter<CreatePartRequest> converter = 
            factory.newInstance(CreatePartRequest.class);        
    }
}