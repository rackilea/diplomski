public void afterPropertiesSet() throws Exception {
_logger.debug("setting test uses data");

User user = new User();
user.setLogin("dmitro");
user.setPassword("2424");
user.setStatus(UserStatus.ACTIVE);
Set<Role> roles = new HashSet<Role>();
Role role = new Role();
role.setRoleName("ROLE_ADMIN");
Set<Permission> permissions = new HashSet<>();
Permission permission = new Permission();
permission.setPermissionName("PERM_SAVE_PRODUCT");
permissions.add(permission);
role.setPermissions(permissions);
roles.add(role);
user.setRoles(roles);
userRepository.save(user);