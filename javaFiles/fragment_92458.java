static class UserAndProfile {
    public UserProfile userprofile;
    public User user;
}
and then your request mappings would resemble

@RequestMapping(value = "/user", method = RequestMethod.GET)
public @ResponseBody UserAndProfile user()  {
    UserAndProfile userAndProfile = new UserAndProfile();
    userAndProfile.userprofile = ...
    userAndProfile.user = ...
    return userAndProfile;
}

@RequestMapping(value = "/user", method = RequestMethod.POST)
public Object user(@RequestBody UserAndProfile userAndProfile) {
    ...
}