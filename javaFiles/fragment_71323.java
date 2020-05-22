private interface Mappable {
    BaseMatcher mapMe(Mapper mapper);
}

public class IntegerMappable {
    private final Integer value;

    public IntegerMappable(Integer value) {
        this.value = value;
    }

    @Override
    public BaseMatcher mapMe(Mapper mapper) {
        return mapper.map(this.value);
    }
}