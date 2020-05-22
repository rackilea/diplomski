private static final List USER_ROLES_TO_SAVE = Arrays.asList(
     StaticValues.LUMEN_SELECT_USER_ROLE,
     StaticValues.EASY_SENSE_USER_ROLE,
     StaticValues.TLED_USER_ROLE,
     StaticValues.IR_APP_USER_ROLE);

protected void saveUserRoles(Set<String> userRoles) {
    if (userRoles == null) {
        return;
    }
    for (String candidate : USER_ROLES_TO_SAVE) {
         if (userRoles.contains(candidate)) {
             preferences.setUserRoles(userRoles);
             return;
         }
    }
}