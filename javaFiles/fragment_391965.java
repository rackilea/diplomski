public class ValidationLibrary {
    private ValidationLibrary() { }
    public boolean validateUsername(Request request, Response response) {
        String name = request.getProperty("username");
        if(name.length() < 3) return false;
        if(name.length() > 12) return false;
        if(name.equals(name.reverse()) return false; // who knows?
        return true;
    }
    public boolean validateSecurity(Request request, Response response) {
        // what page is the user trying to reach?
        SecurityRealm realm = SecurityRealm.realmForPage(request.getProperty("page"));
        String username = request.getProperty("name");
        return realm.allows(username);
    }
}