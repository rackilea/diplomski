public class Factory {


    public <Y, Z> Mapper<Y, Z> create(Class<Y> yClassType) {

        Mapper mapper;
        if (yClassType.equals(One.class)) {
            mapper = new MapperOneTwo();
        } else {
            //Handle default behaviour
        }
        return mapper;
    }

}