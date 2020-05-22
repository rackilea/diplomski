@Test
public void serializeTest() throws JsonProcessingException
{
    ObjectMapper mapper = new ObjectMapper();

    SimpleModule module = new SimpleModule();
    module.addSerializer(ItemRow.class, new ItemRowSerializer());
    mapper.registerModule(module);

    ItemRow item1 = new ItemRow("abc", Arrays.asList("item1", "item2", "item3"));
    String result = mapper.writeValueAsString(item1);
    System.out.println(result);


    ItemRow item2 = new ItemRow("cde", Arrays.asList("item4", "item5"));


    ItemRow item6 = new ItemRow("deeper-1", Arrays.asList("item6", "item7"));
    ItemRow item7 = new ItemRow("deeper-2", Arrays.asList("item6", "item7"));
    ItemRow item8 = new ItemRow("deeper", Arrays.asList(item6, item7));

    ItemRow item3 = new ItemRow("inner-1", Arrays.asList("item6", "item7"));
    ItemRow item4 = new ItemRow("inner-2", Arrays.asList("item6", "item7"));
    ItemRow item5 = new ItemRow("inner", Arrays.asList(item3, item4, item8));




    ItemRow item = new ItemRow("combined", Arrays.asList(item1,item2,item5));
    result = mapper.writeValueAsString(item);
    System.out.println(result);

}