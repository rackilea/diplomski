private TicketRegistry ticketRegistry;
public class LoggedUsersService {
    public List<what_you_want> getLoggedInUsers() {
        List<Principal> userList; // or List<Authentication> or ...
        // extract pricipal list from ticketRegistry
        ...
        return userList;
    }
    public void setTicketRegistry(TicketRegistry ticketRegistry) {
        this.ticketRegistry = ticketRegistry);
    }
}