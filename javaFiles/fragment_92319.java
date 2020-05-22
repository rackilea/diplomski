private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
private static final int REAUTH_ACTIVITY_CODE = 100;
// Check for publish permissions    
List<String> permissions = session.getPermissions();
if (!isSubsetOf(PERMISSIONS, permissions)) {
    Session.ReauthorizeRequest reauthRequest = new Session
           .ReauthorizeRequest(this, PERMISSIONS)
           .setRequestCode(REAUTH_ACTIVITY_CODE);
    session.reauthorizeForPublish(reauthRequest);
    return;
}