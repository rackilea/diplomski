Set<Role> roles = new HashSet<>();
Role userRole = new Role("USER");
userRole.setUser(user);
roles.add(userRole);
Role coolRole = new Role("COOL_GUY");
coolRole.setUser(user);
roles.add(coolRole);
user.setRoleSet(roles);