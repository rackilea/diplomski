@ManagedBean
@ViewScoped
public void ContactsMB {

   @EJB
   private SomeEJB someEJB;
   @ManagedProperty(value = "#{param.username}")
   private String username;
   private User   user;

   @PostConstruct
   public void prepareEditing() {
      this.user = someEJB.loadUserFromDatabase(username);
   }

   // Getters and Setters
}