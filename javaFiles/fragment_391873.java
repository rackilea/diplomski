Set<Role> RoleSet=new HashSet<>();
for(Role r: udto.getRole())
{
    r.setUser(usr);   // <------
    RoleSet.add(r);     
}
usr.setRoleSet(RoleSet);