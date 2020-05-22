public enum UserProfileType implements Serializable{
USER("USER"),
DBA("DBA"),
ADMIN("ADMIN"),
MODERATOR("MODERATOR");

   String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }

    public static List<UserProfileType> getAdminRoles(){
        return Arrays.asList(UserProfileType.USER , UserProfileType.MODERATOR);
    }

}

@ModelAttribute("roles")
public List<UserProfileType> roles(){
   return UserProfileType.getAdminRoles();
}