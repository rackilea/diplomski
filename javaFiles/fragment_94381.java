String login = System.getProperty("development.login");

if (login != null && request.getRemoteUser() == null) {
    String[] nameAndPassword = login.split(":"); // Assuming "name:password".
    request.login(nameAndPassword[0], nameAndPassword[1]);
}