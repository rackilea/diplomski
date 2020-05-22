Class User{
  int id;
  String name;
  String address;
  List<Role> roles;
}

public class Views {
    public static class Public {
    }

    public static class Internal extends Public {
    }
}

Class UserDto {
  @JsonView(Views.Public.class)
  int id;
  @JsonView(Views.Public.class)
  String name;
  @JsonView(Views.Public.class)
  String address;
  @JsonView(Views.Internal.class)
  List<Role> roles;
}

@Controller
Class UserController {
    @JsonView(Views.Public.class)
    public UserDto getUser(int id){...return new UserDto(user);}
    @JsonView(Views.Internal.class)
    public UserDto getUserDetail(int id){...return new UserDetailDto (user);}
}