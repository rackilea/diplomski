@ManagedBean
@ViewScoped
public void ContactsMB {

   @EJB
   private SomeEJB someEJB;
   @ManagedProperty(value = "#{param.username}")
   private String username;
   private User   user;

   private String name;
   private String email;

   @PostConstruct
   public void prepareEditing() {
      this.user  = someEJB.loadUserFromDatabase(username);
      this.name  = user.getName();
      this.email = user.getEmail();
   }

   // Getters and Setters
}