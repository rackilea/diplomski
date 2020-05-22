//                          !!!
if (itemRequestClass.equals(SomeCompletelyDifferentRequest.class))
{
    CreatePartRequestConverter result = new CreatePartRequestConverter();
    return (ItemRequestConverter<IR>) result;
}