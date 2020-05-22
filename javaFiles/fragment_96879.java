public String checkuser() {
    User user = userService.find(username, password);

    if (user == null) {
        return "login";
    } else {
        return "arc";
    }
}