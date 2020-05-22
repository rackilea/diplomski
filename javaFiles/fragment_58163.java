@Component("oauthUserAccess")
public class OauthUserAccess {

    /**
     * Check if it is the administrator of the application IMASTER
     * @param authentication
     * @param projectKey
     * @return
     */
    public boolean hasAdminPermission(OAuth2Authentication authentication, String projectKey) {
        if(authentication.getOAuth2Request().getAuthorities().contains("ROLE_ADMIN")) return true;
        return false;
    }
    /**
     * 
     * @param authentication
     * @param permissionType
     * @param projectKey
     * @return
     */
    public boolean hasPermission(OAuth2Authentication authentication, String permissionType, String projectKey) {
        if (!ProjectPermissionType.exist(permissionType) ||
                projectKey.isEmpty() ||
                !projectKey.matches(Constants.PROJECT_REGEX))
            return false;
        if (authentication.isClientOnly()) {
            //TODO check scope permission
            if(authentication.getOAuth2Request().getScope().contains(permissionType+":"+projectKey)) return true;
        }
        if (hasAdminPermission(authentication, projectKey)) return true;
        String projectPermission = "ROLE_" + permissionType + ":" + projectKey;
        String projectPermissionManage = "ROLE_" + permissionType.replace("VIEW", "MANAGE") + ":" + projectKey;
        String manageProject = "ROLE_" + Constants.PP_MANAGE_PROJECT + ":" + projectKey;
        Predicate<GrantedAuthority> p = r -> r.getAuthority().equals(projectPermission) || r.getAuthority().equals(projectPermissionManage) || r.getAuthority().equals(manageProject);

        if (authentication.getAuthorities().stream().anyMatch(p)) {
            return true;
        };
       return false;
    }

}