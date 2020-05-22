@Mapper(componentModel = "spring")
public abstract class RequestMapper {
    @Mapping(target = "Id", source = "Id")
    @Mapping(target = "data", source = "variables")        
    public abstract Request map(Data variables);

    protected List<Data> mapToList(Data variables) {
        return variables == null ? null : mapToApplication(variables);
    }

    //Add mappings if they are needed
    protected abstract ApplicationData mapToApplication(Data variables);
}