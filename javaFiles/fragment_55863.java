import ...

@RestController
public class MyRestController {

    @javax.inject.Inject
    private Map<String, Mapper<Users>> mappers;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public string getOrders(...) {
        Mapper<Users> usersMapper = getUsersMapperForClient(client);
        // process the request with the right client's mapper
    }

    private Mapper<Users> getUsersMapperForClient(String client) {
        if (mappers.containsKey(client))
            return mappers.get(client);
        throw new RuntimeException("Unknown client: " + client);
    }
}