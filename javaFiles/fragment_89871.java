public class DeserialiserImp<T> implements Deserialiser<T> {

    private ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> klass;

    @Inject
    public DeserialiserImp(TypeLiteral<T> type){
        this.klass = (Class<T>) type.getRawType();
    }

    @Override
    public T get(String content) throws IOException {
        return objectMapper.readValue(content, klass);
    }

    @Override
    public List<T> getList(String content) throws IOException {
        return objectMapper.readValue(content, TypeFactory.collectionType(ArrayList.class, klass));
    }

}