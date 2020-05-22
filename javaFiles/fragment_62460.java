@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class, imports = SecurityUtils.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    @Mapping(target = "modifiedBy", expression = "java(SecurityUtils.getCurrentUserId())")
    User mapUser(UserDto dto);
}