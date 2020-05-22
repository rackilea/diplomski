@Produces
public User getLoggedInUser() throws UserNotLoggedInException {
    if(...){
        return null;
    }
    User user = ... 
    ...
    return user;
}