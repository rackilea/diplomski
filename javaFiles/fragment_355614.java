@Transactionnal 
public void yourMethod(){

        [...]

        Role r = new Role();
        r.setName("New Admin Role");

        for(int i=1; i<=3; i++) {
            Permission p = permissionCrudRepository.getOne(i);
            r.getPermissions().add(p);
            p.getRoles().add(r);
        }

        roleCrudRepository.save(r);
}