@Mapper(uses = { UserMapperResolver.class })
public interface BaseUserMapper {

    BaseUserDto map(User user);

    User map(BaseUserDto baseUser);

}