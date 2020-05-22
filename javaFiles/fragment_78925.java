UserRole ur_user = entityManager.getRoleByType(Role.USER);
UserRole ur_admin = entityManager.getRoleByType(Role.ADMIN);

roles.add(ur_user);
roles.add(ur_admin);

newUser.setRoles(roles);
entityManager.persist(newUser);