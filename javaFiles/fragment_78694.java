@Mapper(componentModel = "spring")
public interface SignUpUserMapper {
    SignUpUserDto signUpUserToSignUpUserDto(SignUpUser signUpUser);
    SignUpUser signUpUserDtoToSignUpUser(SignUpUserDto signUpUserDto);

    default String fromEnum(Title title) {
        return title == null ? null : title.toString();
    }

    default Title toEnum(String title) {
        return title == null ? null : Title.fromString(title);
    }
}