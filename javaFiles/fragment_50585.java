List<MyDTO>[] dtoLists = array(new ArrayList<MyDTO>(), anExistingDtoList);

@SafeVarargs
static <E> E[] array(E... array)
{
    return array;
}