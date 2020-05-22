@UserScope
@Subcomponent(
       modules = {PostsModule.class, ProfileModule.class}
)
public interface ProfileComponent {

   void inject(PostsFragment postsFragment);
   void inject(ProfileActivity profileActivity);

   /**
    * With this you can inject a ProfileComponent.Builder from within
    * the classes that UserComponent provides, or expose it on your enclosing 
    * (sub)component if you'd like. Dagger writes the implementation.
    *
    * Of course, you can skip Modules with zero-arg constructors, because Dagger
    * doesn't need to be provided an instance of those.
    */
   @Subcomponent.Builder interface Builder {
       Builder postsModule(PostsModule postsModule);
       Builder profileModule(ProfileModule profileModule);
       ProfileComponent build();
   }
}