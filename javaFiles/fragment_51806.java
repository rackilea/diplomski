public class MyEnroler implements Enroler {
    public void enrole(ClientInfo clientInfo) {
        Request request = Request.getCurrent();
        User user = request.getClientInfo().getUser();
        if (user!=null) {
            List<UserRole> roles = user.getRoles();
            if (roles!=null) {
                for (UserRole userRole : roles) {
                    // example of role creation
                    Role role = new Role(userRole.getName(), "");
                    clientInfo.getRoles().add(role);
                }
            }
        }
    }
}