// Get keycloak client
Keycloak kc = Keycloak.getInstance("http://localhost:8080/auth",
                "master", "admin", "admin", "admin-cli");

// Create the role
RoleRepresentation clientRoleRepresentation = new RoleRepresentation();
clientRoleRepresentation.setName("client_role");
clientRoleRepresentation.setClientRole(true);
kc.realm("RealmID").clients().findByClientId("ClientID").forEach(clientRepresentation ->
    kc.realm("RealmID").clients().get(clientRepresentation.getId()).roles().create(clientRoleRepresentation)
);

// Create the user
UserRepresentation user = new UserRepresentation();
user.setUsername("test");
user.setEnabled(true);
Response response = kc.realm("RealmID").users().create(user);
String userId = getCreatedId(response);

// Assign role to the user
kc.realm("RealmID").clients().findByClientId("ClientID").forEach(clientRepresentation -> {
    RoleRepresentation savedRoleRepresentation = kc.realm("RealmID").clients()
            .get(clientRepresentation.getId()).roles().get("client_role").toRepresentation();
    kc.realm("RealmID").users().get(userId).roles().clientLevel(clientRepresentation.getId())
            .add(asList(savedRoleRepresentation));
});

// Update credentials to make sure, that the user can log in
UserResource userResource = kc.realm("RealmID").users().get(userId);
userResource.resetPassword(credential);