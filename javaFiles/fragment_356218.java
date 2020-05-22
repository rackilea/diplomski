@Service("userService")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class UserService {

    @RemotingExclude
    @RequestMapping("/user/{id}", method=RequestMethod.GET)
    public String getUserByIdRest(@PathVariable String id) {
        return this.getUserById(id);
    }

    @RemotingInclude
    public String getUserById(String id) {
       //..
       return id;
    }
}