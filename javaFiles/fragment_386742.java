import com.backend.mypackage.a.b.c.UserDto;

public class ImportAlias {
    static class UserDtoAlias extends com.backend.mypackage.a.b.c.d.UserDto {
    }

    public static void main(String[] args) {
        UserDto userBackend = new UserDto();
        UserDtoAlias userService = new UserDtoAlias();

        mapper(userBackend, userService);
    }

    private static void mapper(UserDto userBackend, UserDtoAlias userService) {
        // ...
    }
}