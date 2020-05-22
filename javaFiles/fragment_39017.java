static void checkAccess() throws Throwable {
    // Authent
    if (!session.contains("username")) {            
        login(request.method.equals("GET") ? request.url : "/");
    }
}