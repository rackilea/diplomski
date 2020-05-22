@Mapper
@DecoratedWith(TagMapperDecorator.class)
public interface TagMapper {
    @Mappings({
        @Mapping(target = "id", source = "tagId"),
        @Mapping(target = "label", source = "tagLabel")
    })
    Tag mapToBean(TagRecord tagRecord);
}


public abstract class TagMapperDecorator implements TagMapper {

    private final TagMapper delegate;

    public TagMapperDecorator(TagMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public Tag mapToBean(TagRecord tagRecord) {
        Tag tag = delegate.mapToBean( tagRecord);

        if (tag != null && tag.getId() == null && tag.getLabel() == null) {
            return null;
        } else {
            return tag;
        }
    }
}