class User {
   @Column
   private String name;

   @OneToOne(mappedBy="role_id")
   private Role role;
   .... getter/setter....
}

class Role {
  ...
}