public String getObjectAsString()
{

    //orderObjs : Considering this is the list of objects of class Order

    ObjectMapper objMapper = new ObjectMapper();
            returnValue = objMapper.writerWithType(
                    objMapper.getTypeFactory().constructCollectionType(
                            List.class, Order.class)).writeValueAsString(
                    orderObjs);
    return returnValue;
}