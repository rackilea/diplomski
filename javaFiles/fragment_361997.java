import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();

    Map<String, String> requestMap = new HashMap<String, String>();
    requestMap.put("one", "1");
    requestMap.put("two", "2");

    System.out.println(mapper.writeValueAsString(requestMap));
    // output: {"two":"2","one":"1"}

    List<UserPermission> userPermissions = new ArrayList<UserPermission>();
    userPermissions.add(new UserPermissionImpl("domain1"));
    userPermissions.add(new UserPermissionImpl("domain2"));

    System.out.println(mapper.writeValueAsString(userPermissions));
    // output: [{"scope":"domain1"},{"scope":"domain2"}]

    Container container = new ContainerImpl(requestMap, userPermissions);

    // From an Interface-type reference, where the implementation is an object with two Interface-type references:
    System.out.println(mapper.writeValueAsString(container));
    // {"requestMap":{"two":"2","one":"1"},"userPermissions":[{"scope":"domain1"},{"scope":"domain2"}]}
  }
}

interface UserPermission {}

class UserPermissionImpl implements UserPermission
{
  public String scope;
  UserPermissionImpl(String scope) { this.scope = scope; }
}

interface Container {}

class ContainerImpl implements Container
{
  public Map<String, String> requestMap;
  public List<UserPermission> userPermissions;

  ContainerImpl(Map<String, String> requestMap, List<UserPermission> userPermissions)
  { this.requestMap = requestMap; this.userPermissions = userPermissions; }
}