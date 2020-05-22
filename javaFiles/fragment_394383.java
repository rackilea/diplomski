public class ObjectMapperFactory implements Factory<ObjectMapper> {

    final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ObjectMapper provide() {
        return mapper;
    }

    @Override
    public void dispose(ObjectMapper t) {}   
}