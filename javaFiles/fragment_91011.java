ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

permissionChecker.isCompanyAdmin() //   Returns true if the user is an administrator of their company.
permissionChecker.isOmniadmin()  //      Returns true if the user is a universal administrator.
permissionChecker.isGroupAdmin(long groupId)  //  Returns true if the user is an administrator of the group.