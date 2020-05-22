public class com.myapp.somesite.web.SomeSiteUserModel {

   public static SomeSiteUserModel from(UserEntity userEntity) {
      ... initialize model ...
   }

   public UserEntity getModelObject() {
      ... get entity back ... 
   }

}