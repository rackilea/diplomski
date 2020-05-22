// the one
@RequestMapping(value = "save", method = RequestMethod.POST)
public @ResponseBody UserResponse save(@RequestBody User user) throws Exception {
    UserResponse userResponse = new UserResponse();
    return userResponse;
}


</form>
<form action="/webapp/history/save" method="POST" enctype="application/x-www-form-urlencoded">
    <input name="userId" value="user">
    <input name="location" value="location">
    <input name="emailAddress" value="hello@hello.com">
    <input name="commitMessage" value="I">
    <input type="submit" value="Submit">
</form>


// the other
@RequestMapping(value = "save", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
public @ResponseBody UserResponse save(@RequestBody User user) throws Exception {
    UserResponse userResponse = new UserResponse();
    return userResponse;
}


</form>
<form action="/webapp/history/save" method="POST" enctype="application/json">
    <input name="userId" value="user">
    <input name="location" value="location">
    <input name="emailAddress" value="hello@hello.com">
    <input name="commitMessage" value="I">
    <input type="submit" value="Submit">
</form>