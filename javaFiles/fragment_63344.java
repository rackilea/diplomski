try {
            User user = (User) req.getAttribute(WebKeys.USER);
            PrincipalThreadLocal.setName(userId);
            PermissionChecker permissionChecker;

            permissionChecker = PermissionCheckerFactoryUtil.create(user);
            PermissionThreadLocal.setPermissionChecker(permissionChecker);

            Organization organization = mylist.get(0);

            ExpandoBridge expandoBridge = organization.getExpandoBridge();
            System.out.println(expandoBridge.getAttribute("custom_field"));
} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
}