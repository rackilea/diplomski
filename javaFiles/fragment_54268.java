@RequestMapping(value = "/users/{username}",params = {"action="+Action.CREATE}, method = RequestMethod.POST)
@ResponseStatus(HttpStatus.CREATED)
public UserModel createUser(@PathVariable(value="username") String username, @RequestBody UserModel user) {

    user.setUsername(username);
    return userService.createUser(user);

}