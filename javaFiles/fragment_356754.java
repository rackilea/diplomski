// create a new instance based on the configuration defined in keycloak-authz.json
AuthzClient authzClient = AuthzClient.create();

// send the authorization request to the server in order to
// obtain an access token granted to the user
AccessTokenResponse response = authzClient.obtainAccessToken("alice", "alice");