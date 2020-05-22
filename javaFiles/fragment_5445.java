Date roleDate = getRoleDateFromSession(session);
String roleName = getRoleNameFromSession(session);
if (roleUpdateTimes.roleIsStale(roleName, roleDate)) {
    ... reload role permissions from database and save them to session
    saveRoleDateToSession(session, new Date());
}