Set<UserRole> roles = new HashSet<UserRole> ();
// Guess for roles, should be needed to load them also from the db
for(UserRole role : user.getUserRole()) {
    roles.add(new UserRole(userpersis,role.getRole())); 
}

userpersis.setUserRole(roles);