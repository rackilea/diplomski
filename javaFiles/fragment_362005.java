public interface UserDTO
{
    boolean deleteUser(String userId);
    UserVO readUser(String userId);
    void updateUser(String userId, UserVO newValues);
}

package blah.blammy;
public class UserDTOImpl implements UserDTO
{
  ... implement it based on blammy.
}

package blah.kpow;
public class UserDTOImpl implements UserDTO
{
  ... implement it based on kpow.
}