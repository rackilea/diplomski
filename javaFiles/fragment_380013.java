@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    org.library.webservice.service.generated.user.User toDto(org.library.webservice.model.User user);

    org.library.webservice.model.User toEntity(org.library.webservice.service.generated.user.User user);
}