@Entity
class User implements Serializable {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Access(AccessType.PROPERTY)
   @Embedded
   private Profile profile;

   public Profile getProfile() {
      return profile;
   }

   public void setProfile(Profile profile) {
      this.profile = profile;
      this.profile.setUser(this);
   }

   // ...
}